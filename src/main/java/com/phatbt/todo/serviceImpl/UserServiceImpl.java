package com.phatbt.todo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.phatbt.todo.dto.UserDto;
import com.phatbt.todo.entities.User;
import com.phatbt.todo.exception.ResourceNotFoundException;
import com.phatbt.todo.repositories.UserRepository;
import com.phatbt.todo.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User saveUser(UserDto userDto) {
		
		User user = new User();
		
		userDto.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
		
		user.setId(userDto.getId());
		user.setUserName(userDto.getUserName());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		
		return this.userRepo.save(user);
	}

	@Transactional
	@Override
	public User updateUser(UserDto userDto) {

		User user = this.userRepo.findById(userDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User Id Not Found!!!"));
		
		userDto.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
		
		user.setId(userDto.getId());
		user.setUserName(userDto.getUserName());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		
		return this.userRepo.save(user);
	}

	@Transactional
	@Override
	public void deleteUser(UserDto userDto) {
		
		User user = this.userRepo.findById(userDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User Id Not Found!!!"));
		
		this.userRepo.delete(user);
	}

	@Override
	public List<User> findAllUsers() {
		
		List<User> userList = new ArrayList<User>();
		
		this.userRepo.findAll().forEach(users -> userList.add(users));
		
		return userList;
	}

}
