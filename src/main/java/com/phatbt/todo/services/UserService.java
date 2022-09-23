package com.phatbt.todo.services;

import java.util.List;

import com.phatbt.todo.dto.UserDto;
import com.phatbt.todo.entities.User;

public interface UserService {
	
	User saveUser(UserDto userDto);
	
	User updateUser(UserDto userDto);
	
	void deleteUser(int userId);
	
	List<User> findAllUsers();
}
