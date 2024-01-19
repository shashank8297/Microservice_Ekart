package com.infinite.orders_details.valueobject;

public class Orders {

	private Long orderId;

	private String orderAmount;

	private String orderCustomerName;

	private String orderCustomerAddress;

	private String orderCustomerEmail;

	private String orderCustomerPhone;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOrderCustomerName() {
		return orderCustomerName;
	}

	public void setOrderCustomerName(String orderCustomerName) {
		this.orderCustomerName = orderCustomerName;
	}

	public String getOrderCustomerAddress() {
		return orderCustomerAddress;
	}

	public void setOrderCustomerAddress(String orderCustomerAddress) {
		this.orderCustomerAddress = orderCustomerAddress;
	}

	public String getOrderCustomerEmail() {
		return orderCustomerEmail;
	}

	public void setOrderCustomerEmail(String orderCustomerEmail) {
		this.orderCustomerEmail = orderCustomerEmail;
	}

	public String getOrderCustomerPhone() {
		return orderCustomerPhone;
	}

	public void setOrderCustomerPhone(String orderCustomerPhone) {
		this.orderCustomerPhone = orderCustomerPhone;
	}
}
