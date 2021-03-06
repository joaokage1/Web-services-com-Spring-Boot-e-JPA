package com.example.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.example.course.model.User;
import com.example.course.repositories.UserRepository;
import com.example.course.services.exceptions.DatabaseException;
import com.example.course.services.exceptions.ResourceNotFoundException;

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
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insertUser(User user) {
		return getRepository().save(user);
	}

	public void deleteUser(Long id) {
		try {
			getRepository().deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public User updateUser(Long id, User user) {
		try {
			User entity = getRepository().getOne(id);
			updateData(entity, user);
			return getRepository().save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}
}
