package com.example.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.course.model.User;
import com.example.course.repositories.UserRepository;

@Component
public class UserService {

	@Autowired
	private UserRepository repository;

	public UserRepository getRepository() {
		return this.repository;
	}

	public List<User> fetchAll() {
		return getRepository().findAll();
	}

	public User fetchUserById(Long id) {
		Optional<User> user = getRepository().findById(id);
		return user.get();
	}
}
