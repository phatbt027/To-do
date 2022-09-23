package com.phatbt.todo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phatbt.todo.dto.TaskDto;
import com.phatbt.todo.entities.Task;
import com.phatbt.todo.services.TaskService;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;

	@GetMapping("/tasks")
	public List<Task> getAllTask() {
		
		return this.taskService.findAllTasks();
	}
	
	@PostMapping("/task")
	public Task addTask(@RequestBody TaskDto taskDto) {
		
		return this.taskService.saveTask(taskDto);
	}
	
	@PutMapping("/task/{id}")
	public Task editTask(@RequestBody TaskDto taskDto) {
		
		return this.taskService.updateTask(taskDto);
	}
	
	@DeleteMapping("/task/{id}")
	public String removeTask(@RequestBody TaskDto taskDto) {
		
		this.taskService.deleteTask(taskDto.getId());
		
		return "Delete Successfuly";
	}
}
