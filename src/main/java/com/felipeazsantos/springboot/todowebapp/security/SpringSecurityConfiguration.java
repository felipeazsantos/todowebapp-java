package com.felipeazsantos.springboot.todowebapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		UserDetails userDetails = createNewUser("felipe", "dummy");
		UserDetails userDetails2 = createNewUser("azevedo", "123");
		return new InMemoryUserDetailsManager(userDetails, userDetails2);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	private UserDetails createNewUser(String username, String password) {
		// Lambda Function - recebe uma String e retorna uma String
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
	
		return User.builder()
					.passwordEncoder(passwordEncoder)
					.username(username)
					.password(password)
					.roles("USER", "ADMIN")
						.build();
	}
}
