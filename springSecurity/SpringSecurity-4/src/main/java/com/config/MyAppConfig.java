package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MyAppConfig {
	@Bean
	public SecurityFilterChain mySecurityConfig(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests( (auth) -> {
			auth.requestMatchers("/welcome", "/register", "/welcome/{username}").permitAll()
			 	.requestMatchers("/swagger-ui*/**","/v3/api-docs/**").permitAll()
				.requestMatchers("/hello").authenticated()
				.requestMatchers("/admin").hasRole("admin");
		}).csrf().disable().httpBasic();
		
		return http.build();
	}
	
	@Bean
	 public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	 }
}
