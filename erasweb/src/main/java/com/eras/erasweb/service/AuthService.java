package com.eras.erasweb.service;

import com.eras.erasweb.dto.LoginDTO;
import com.eras.erasweb.dto.LoginResponseDTO;

public interface AuthService {
	public LoginResponseDTO login(LoginDTO loginDTO);
}
