package com.infinite.orders_details.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order_Details {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderDetailsId;
	private Long userId;
	private Long productId;
	private Long orderId;
	public Long getOrderDetailsId() {
		return orderDetailsId;
	}
	public void setOrderDetailsId(Long orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
}