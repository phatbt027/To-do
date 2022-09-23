package com.phatbt.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phatbt.todo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
