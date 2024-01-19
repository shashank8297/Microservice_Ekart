package com.infinite.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.orders.model.Orders;
import com.infinite.orders.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping("/newOrder")
	public Orders newOrder(@RequestBody Orders order) {
		return orderService.newOrder(order);
	}

	@GetMapping("/{id}")
	public Orders orderDetails(@PathVariable("id") Long orderId) {
		return orderService.orderDetails(orderId);
	}

	/*
	 * @PostMapping("/removeOrder/{id}") public String
	 * removeOrder(@PathVariable("id") Long orderId) {
	 * orderService.removeOrder(orderId);
	 * 
	 * Order order = new Order(); Long oId = order.getOrderId();
	 * 
	 * String msg = orderId+" is removed"; return msg; }
	 */

}
