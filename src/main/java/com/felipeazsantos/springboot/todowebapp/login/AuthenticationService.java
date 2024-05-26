package com.felipeazsantos.springboot.todowebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public Boolean authenticate(String username, String password) {
		Boolean isValidUsername = username.equals("felipe");
		Boolean isValidPassword = password.equals("dummy");
		return isValidUsername && isValidPassword;
	}
}
