package com.phatbt.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phatbt.todo.entities.Tasks;

public interface TaskRepository extends JpaRepository<Tasks, Integer> {

}
