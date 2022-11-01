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

import com.phatbt.todo.dto.TaskDto;
import com.phatbt.todo.entities.Task;
import com.phatbt.todo.services.TaskService;

@RestController
@RequestMapping("/task")
public class TaskRestController {
	
	@Autowired
	private TaskService taskService;

	@GetMapping
	public List<Task> showAllTask() {
		
		return this.taskService.findAllTasks();
	}
	
	@PostMapping("add")
	public Task addTask(@RequestBody TaskDto taskDto) {

		return this.taskService.saveTask(taskDto);
	}
	
	@PutMapping("edit/{taskId}")
	public Task editTask(@RequestBody TaskDto taskDto) {
		
		return this.taskService.updateTask(taskDto);
	}
	
	@DeleteMapping("delete/{taskId}")
	public String removeTask(@RequestBody TaskDto taskDto) {
		
		this.taskService.deleteTask(taskDto.getId());
		
		return "Delete Successfuly";
	}
}
