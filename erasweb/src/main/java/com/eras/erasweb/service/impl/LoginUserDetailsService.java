package com.eras.erasweb.service.impl;

//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import com.eras.erasweb.model.User;
import com.eras.erasweb.dto.*;
import com.eras.erasweb.model.User;
import com.eras.erasweb.repository.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class LoginUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> appUser = userRepository.findByUserDefinedID(username);
		if(appUser.isPresent()) {
			var userObj = appUser.get();
			String role;
			String userTypeDesc=userObj.getUserTypeDesc();
			switch (userTypeDesc){ 
				case "DATA INPUT" :
					role="USER";
					break;
				case "ADMIN" :
					role="ADMIN";
					break;
				default:
					role="USER";
			}		
			

			return  org.springframework.security.core.userdetails.User.builder()
					.username(userObj.getUserDefinedID())
					.password(userObj.getPassword())
					.roles(role)
					.build();
		} 
		else {throw new UsernameNotFoundException(username);}
			
	
	}

}
