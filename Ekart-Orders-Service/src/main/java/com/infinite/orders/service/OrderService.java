package com.infinite.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinite.orders.model.Orders;
import com.infinite.orders.repository.OrderRepository;

@Service
public class OrderService implements IOrderService {

	@Autowired
	OrderRepository orderRepository;

	public Long newOrder(Orders order) {
		// TODO Auto-generated method stub
		orderRepository.save(order);
		
		return order.getOrderId();
	}

	public Orders orderDetails(Long orderId) {
		// TODO Auto-generated method stub
		//return orderRepository.findByOrderId(orderId).orElseThrow(IllegalArgumentException::new);
		return orderRepository.findByOrderId(orderId);
	}

	public void removeOrder(Long orderId) {
		// TODO Auto-generated method stub
		orderRepository.deleteById(orderId);

	}

}
