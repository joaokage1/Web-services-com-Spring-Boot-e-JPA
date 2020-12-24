package com.example.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
