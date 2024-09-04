package com.eras.erasweb.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class SessionCheckInterceptor implements HandlerInterceptor {

    //@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("/login?session=expired");
            return false;
        }
        if (session == null || session.getAttribute("hospital") == null) {
            response.sendRedirect("/login?session=expired");
            return false;
        }
        
        return true;
    }
}
