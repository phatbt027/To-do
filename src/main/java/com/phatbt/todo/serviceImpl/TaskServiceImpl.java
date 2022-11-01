package com.phatbt.todo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.phatbt.todo.dto.TaskDto;
import com.phatbt.todo.entities.Task;
import com.phatbt.todo.entities.User;
import com.phatbt.todo.exception.ResourceNotFoundException;
import com.phatbt.todo.repositories.TaskRepository;
import com.phatbt.todo.repositories.UserRepository;
import com.phatbt.todo.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	private Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	
	private User user = userRepo.findUserByUserName(authentication.getName()).orElseThrow();
	
	@Override
	public Task saveTask(TaskDto taskDto) {

		Task task = new Task();
		
		task.setId(taskDto.getId());
		task.setTaskName(taskDto.getTaskName());
		task.setStartDate(taskDto.getStartDate());
		task.setEndDate(taskDto.getEndDate());
		task.setNote(taskDto.getNote());
		task.setFinished(false);
		task.setUser(user);
		
		return this.taskRepo.save(task);
	}

	@Override
	public Task updateTask(TaskDto taskDto) {
		
		Task task = this.taskRepo.findById(taskDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Task Not Found!!!"));
		
		task.setId(taskDto.getId());
		task.setTaskName(taskDto.getTaskName());
		task.setStartDate(taskDto.getStartDate());
		task.setEndDate(taskDto.getEndDate());
		task.setNote(taskDto.getNote());
		task.setFinished(taskDto.isFinished());
		task.setUser(user);
		
		return this.taskRepo.save(task);
	}

	@Override
	public void deleteTask(int taskId) {
		
		Task task = this.taskRepo.findById(taskId)
				.orElseThrow(() -> new ResourceNotFoundException("Task Not Found!!!"));
		
		this.taskRepo.deleteById(task.getId());	
	}

	@Override
	public List<Task> findAllTasks() {
		
		return taskRepo.findAll();
	}

}
