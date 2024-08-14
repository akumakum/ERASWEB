package com.eras.erasweb.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.eras.erasweb.model.Hospital;
import com.eras.erasweb.model.MainPageURL;
import com.eras.erasweb.service.HospitalService;
import com.eras.erasweb.service.MainPageURLService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private final HospitalService hospitalService;
    @Autowired
    private MainPageURLService mainPageURLService;

    public AuthenticationSuccessHandler(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws ServletException, IOException {
        String username = authentication.getName();
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
        
        httpServletRequest.getSession().setAttribute("username", username);

        // Load hospital details
        Hospital hospital = hospitalService.ShowIfExist();
        httpServletRequest.getSession().setAttribute("hospital", hospital);
        MainPageURL mainPageURL=mainPageURLService.ShowIfExist();
        
        httpServletRequest.getSession().setAttribute("mainPageURL",mainPageURL);
	
        
       
        try {
			if (hospital.getHospitalCode().isEmpty()){
				 httpServletRequest.getSession().setAttribute("shospitalCode", "NOT SETUP");
			}else
			{
				 httpServletRequest.getSession().setAttribute("shospitalCode", hospital.getHospitalCode());
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			httpServletRequest.getSession().setAttribute("shospitalCode", "NOTSETUP");
			httpServletRequest.getSession().setAttribute("sguideURL","Please Setup");
			httpServletRequest.getSession().setAttribute("sintroURL","Please Setup");
			//e.printStackTrace();
		}
        
        
        if (isAdmin) {
            setDefaultTargetUrl("/maintenance/home");
        } else {
            setDefaultTargetUrl("/patient/home");
        }

        super.onAuthenticationSuccess(httpServletRequest, httpServletResponse, authentication);
    }
}



