package com.phatbt.todo.services;

import java.util.List;

import com.phatbt.todo.dto.TaskDto;
import com.phatbt.todo.entities.Task;

public interface TaskService {
	
	Task saveTask(TaskDto taskDto);
	
	Task updateTask(TaskDto taskDto);
	
	void deleteTask(int taskId);
	
	List<Task> findAllTasks();
}
