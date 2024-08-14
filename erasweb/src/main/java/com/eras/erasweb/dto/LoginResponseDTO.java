package com.eras.erasweb.dto;

public class LoginResponseDTO {
    private String token;
    private String username;
    
	public LoginResponseDTO(String token2, String fullName) {
		// TODO Auto-generated constructor stub
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

    // Getters and Setters
}
