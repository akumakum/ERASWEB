package com.eras.erasweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Autowired
    private UserDetailsService userDetailService;

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/patientrecords/**").hasRole("USER");
                    registry.requestMatchers("/maintenance/**").hasRole("ADMIN");
                    registry.requestMatchers("/reports/**").hasRole("REPORTS");
                    registry.requestMatchers("/ajax/**").permitAll();
                    registry.requestMatchers("/backup/**").permitAll();
                    registry.anyRequest().authenticated();
                //    registry.anyRequest().permitAll();
                    
                    
                    
                    
                    
                })
                .formLogin(httpSecurityFormLoginConfigurer -> {
                    httpSecurityFormLoginConfigurer.loginPage("/login")
                            .successHandler(authenticationSuccessHandler)
                            .permitAll();
                })
                .build();
    }

    @Bean
    public UserDetailsService userDetailService() {
        return userDetailService;
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
//    @Bean
//    WebSecurityCustomizer websecurityCustomizer() {
//    	return (web)->web.ignoring().requestMatchers("/ajax/**");
//    }
}






//package com.eras.erasweb.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//
//@Configuration
//public class SecurityConfiguration {
//	
//	@Autowired
//	UserDetailsService userDetailService;
//	
//	@Bean
//	SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
//		return httpSecurity
//				.csrf(AbstractHttpConfigurer::disable)
//				.authorizeHttpRequests(registry->{
//			registry.requestMatchers("/patientrecords/**").hasRole("ADMIN");
//			registry.requestMatchers("/maintenance/**").hasRole("ADMIN"); //temp until there is a new endpoint for patient
//			registry.requestMatchers("/reports/**").hasRole("REPORTS");
//		//	registry.anyRequest().permitAll();
//			registry.anyRequest().authenticated() ;   //.permitAll();   //authenticated();
//		})
//				.formLogin(httpSecurityFormLoginConfigurer -> { 
//					httpSecurityFormLoginConfigurer.loginPage("/login")
//					.successHandler(new AuthenticationSuccessHandler())
//					.permitAll();
//					
//				})
//				
//				
//				//.formLogin().loginPage("/login")
//
//		.build();
//	}
//	
//
//	
//	@Bean
//	public UserDetailsService userDetailService() {
//		return userDetailService;
//	}
//	
//	
//	
//	@Bean
//	AuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailService);
//		provider.setPasswordEncoder(passwordEncoder());
//		return provider;
//		
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//}
