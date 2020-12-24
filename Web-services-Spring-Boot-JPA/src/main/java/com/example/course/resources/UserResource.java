package com.example.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.model.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping("/fetch-all")
	public ResponseEntity<User> fetchAll() {
		User user = new User(1L, "Toddy", "joao@gmail.com", "9999999", "123456");
		return ResponseEntity.ok().body(user);
	}
}
