package com.example.course.model.enums;

public enum OrderStatus {
	WAITING_PAYMENT(0), SHIPPED(1), PAID(2), DELIVERED(3), CANCELED(4);

	private Integer code;

	OrderStatus(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return this.code;
	}

	public static OrderStatus valueOf(Integer code) {
		for (OrderStatus status : OrderStatus.values()) {
			if (status.getCode() == code) {
				return status;
			}
		}
		throw new IllegalArgumentException("Invalid Code");
	}
}
