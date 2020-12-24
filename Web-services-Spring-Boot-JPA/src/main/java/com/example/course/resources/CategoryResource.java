package com.example.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.model.Category;
import com.example.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryService service;

	public CategoryService getService() {
		return this.service;
	}

	@GetMapping
	public ResponseEntity<List<Category>> fetchAll() {
		return ResponseEntity.ok().body(getService().fetchAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> fetchCategoryById(@PathVariable Long id) {
		Category category = getService().fetchCategoryById(id);
		return ResponseEntity.ok().body(category);
	}
}
