package com.example.course.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.course.model.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();

	private Integer quantity;
	private Double price;

	public OrderItem() {

	}

	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		super();
		this.id.setOrder(order);
		this.id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@JsonIgnore
	public Order getOrder() {
		return this.id.getOrder();
	}

	public void setOrder(Order order) {
		this.id.setOrder(order);
	}

	public Product getProduct() {
		return this.id.getProduct();
	}

	public void setProduct(Product product) {
		this.id.setProduct(product);
	}

	public Double getSubTotal() {
		return getPrice() * getQuantity();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		OrderItem other = (OrderItem) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
