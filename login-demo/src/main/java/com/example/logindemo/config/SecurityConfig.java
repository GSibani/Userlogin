package com.example.logindemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.logindemo.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	  private final CustomUserDetailsService customUserDetailsService;

	    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
	        this.customUserDetailsService = customUserDetailsService;
	    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            // Configure security settings
	    	http
            .authorizeRequests()
                .requestMatchers("/hello").authenticated()  // Only authenticated users can access "/hello"
                .anyRequest().permitAll()  // Allow access to all other requests
            .and()
            .formLogin()
                .loginPage("/login")  // Customize login page
                .permitAll()  // Allow everyone to access login page
            .and()
            .logout()
                .permitAll();  // Allow logout for all users

        return http.build();
	    }

	    @Bean
	    public UserDetailsService userDetailsService() {
	        return customUserDetailsService;
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

}
