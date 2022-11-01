package com.phatbt.todo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.phatbt.todo.entities.User;
import com.phatbt.todo.exception.ResourceNotFoundException;
import com.phatbt.todo.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	public CustomUserDetailsService(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findUserByUserName(username)
				.orElseThrow(() -> new ResourceNotFoundException("User not found!!!"));
		
		try {
			
			UserDetails userDetails = org.springframework.security.core.userdetails.User
									.withUsername(user.getUserName())
									.password(user.getPassword())
									.roles(user.getRole())
									.build();
		
			return userDetails;
			
		} catch (UsernameNotFoundException ex) {
			
			throw new UsernameNotFoundException("Invaild Username or Password");
		}
	}

}
