package com.example.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.model.Product;
import com.example.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService service;

	public ProductService getService() {
		return this.service;
	}

	@GetMapping
	public ResponseEntity<List<Product>> fetchAll() {
		return ResponseEntity.ok().body(getService().fetchAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> fetchProductById(@PathVariable Long id) {
		Product product = getService().fetchProductById(id);
		return ResponseEntity.ok().body(product);
	}
}
