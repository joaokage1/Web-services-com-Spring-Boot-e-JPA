package com.example.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.course.model.Product;
import com.example.course.repositories.ProductRepository;

@Component
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public ProductRepository getRepository() {
		return this.repository;
	}

	public List<Product> fetchAll() {
		return getRepository().findAll();
	}

	public Product fetchProductById(Long id) {
		Optional<Product> product = getRepository().findById(id);
		return product.get();
	}
}
