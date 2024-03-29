package com.infinite.orders.service;

import com.infinite.orders.model.Orders;

public interface IOrderService {

	public Long newOrder(Orders order);
	
	public Orders orderDetails(Long orderId);
	
	public void removeOrder(Long orderId);
	
}
