package com.example.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.course.model.Category;
import com.example.course.repositories.CategoryRepository;

@Component
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public CategoryRepository getRepository() {
		return this.repository;
	}

	public List<Category> fetchAll() {
		return getRepository().findAll();
	}

	public Category fetchCategoryById(Long id) {
		Optional<Category> category = getRepository().findById(id);
		return category.get();
	}
}
