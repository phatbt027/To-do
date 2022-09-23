package com.phatbt.todo.dto;

import java.sql.Date;

import com.phatbt.todo.entities.User;

import lombok.Data;

@Data
public class TaskDto {

	private int id;

	private User user;

	private String taskName;

	private Date startDate;

	private Date endDate;

	private String note;

	private boolean finished;
}
