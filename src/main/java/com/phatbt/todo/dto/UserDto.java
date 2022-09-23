package com.phatbt.todo.dto;

import lombok.Data;

@Data
public class UserDto {
	
	private int id;
	
	private String userName;
	
	private String password;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
}
