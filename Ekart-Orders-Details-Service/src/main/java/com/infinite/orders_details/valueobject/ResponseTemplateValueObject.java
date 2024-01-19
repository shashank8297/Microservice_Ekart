package com.infinite.orders_details.valueobject;

import com.infinite.orders_details.model.Order_Details;

public class ResponseTemplateValueObject {

	private Order_Details orderDetails;
	
	private User user;
	private Product product;
	private Orders order;
	public Order_Details getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(Order_Details orderDetails) {
		this.orderDetails = orderDetails;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	
}
