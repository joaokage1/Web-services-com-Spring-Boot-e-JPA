package com.example.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.model.Order;
import com.example.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService service;

	public OrderService getService() {
		return this.service;
	}

	@GetMapping("/fetch-all-orders")
	public ResponseEntity<List<Order>> fetchAll() {
		return ResponseEntity.ok().body(getService().fetchAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> fetchOrderById(@PathVariable Long id) {
		Order Order = getService().fetchOrderById(id);
		return ResponseEntity.ok().body(Order);
	}
}
