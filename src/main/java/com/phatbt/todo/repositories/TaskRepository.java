package com.phatbt.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phatbt.todo.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
