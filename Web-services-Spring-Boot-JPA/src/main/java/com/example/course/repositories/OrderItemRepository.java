package com.example.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
