package com.phatbt.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phatbt.todo.entities.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

}
