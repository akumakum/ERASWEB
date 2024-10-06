package com.eras.erasweb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eras.erasweb.dto.UserDTO;
import com.eras.erasweb.dto.UserPositionDTO;
import com.eras.erasweb.dto.UserTypeDTO;

@Controller
public class AuthController {

	@GetMapping("/login")

	public String LoginForm(Model model) {

		return "Login";

	}
	
	@GetMapping("/")

	public String Login(Model model) {

		return "Login";

	}


}
