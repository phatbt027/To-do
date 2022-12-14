package com.phatbt.todo.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configurable
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
			.csrf().disable()
			.authorizeRequests().antMatchers("/home").permitAll()
								.antMatchers("/user/**").hasRole("ADMIN")
								.antMatchers("/task/**").authenticated()
								.and()
								.formLogin()
								.loginPage("/login")
								.failureUrl("/login?error")
								.defaultSuccessUrl("/home")
								.and()
								.exceptionHandling()
									.accessDeniedPage("/403")
								.and()
								.httpBasic()
								.and()
								.logout( logout -> logout
													.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
													.permitAll()
													);
		
		return http.build();
	}
}
