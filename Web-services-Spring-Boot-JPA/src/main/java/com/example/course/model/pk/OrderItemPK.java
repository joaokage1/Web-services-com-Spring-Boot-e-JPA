package com.example.course.model.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.course.model.Order;
import com.example.course.model.Product;

@Embeddable
public class OrderItemPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.order == null) ? 0 : this.order.hashCode());
		result = (prime * result) + ((this.product == null) ? 0 : this.product.hashCode());
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
		OrderItemPK other = (OrderItemPK) obj;
		if (this.order == null) {
			if (other.order != null) {
				return false;
			}
		} else if (!this.order.equals(other.order)) {
			return false;
		}
		if (this.product == null) {
			if (other.product != null) {
				return false;
			}
		} else if (!this.product.equals(other.product)) {
			return false;
		}
		return true;
	}
}
