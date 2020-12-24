package com.example.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.course.model.User;
import com.example.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	public UserService getService() {
		return this.service;
	}

	@GetMapping("/fetch-all")
	public ResponseEntity<List<User>> fetchAll() {
		return ResponseEntity.ok().body(getService().fetchAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> fetchUserById(@PathVariable Long id) {
		User user = getService().fetchUserById(id);
		return ResponseEntity.ok().body(user);
	}

	@PostMapping
	public ResponseEntity<User> insertUser(@RequestBody User user) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{}id").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(getService().insertUser(user));
	}
}
