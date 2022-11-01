package com.phatbt.todo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phatbt.todo.dto.UserDto;
import com.phatbt.todo.entities.User;
import com.phatbt.todo.services.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> showAllUsers() {
		
		return this.userService.findAllUsers();
	}
	
	@PostMapping("add")
	public User addUser(@RequestBody UserDto userDto) {
		
		return this.userService.saveUser(userDto);
	}
	
	@PutMapping("update/{userId}")
	public User editUser(@RequestBody UserDto userDto) {
		
		return this.userService.updateUser(userDto);
	}
	
	@DeleteMapping("delete/{userId}")
	public String deleteUser(@RequestBody UserDto userDto) {
		
		this.userService.deleteUser(userDto);
		
		return "Delete Successfully";
	}
}
