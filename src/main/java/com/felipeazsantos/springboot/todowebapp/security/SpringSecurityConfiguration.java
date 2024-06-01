package com.felipeazsantos.springboot.todowebapp.security;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// garante a proteção de todas as requisições/url, precisando estar autenticado
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());
		
		// mostra o login form
		http.formLogin(withDefaults());
		
		// para acessar o console do H2 precisamos desabilitar as proteções de CSRF e Frames
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		return http.build();
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
