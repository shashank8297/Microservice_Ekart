package com.infinite.orders_details.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.orders_details.model.Order_Details;
import com.infinite.orders_details.service.Order_DetailsService;
import com.infinite.orders_details.valueobject.ResponseTemplateValueObject;

@RestController
@RequestMapping("/orderDetails")
public class Order_detailsController {

	@Autowired
	Order_DetailsService orderDetailsService;

	@PostMapping("/addOrderDetails")
	public Long addNewOrderDetails(@RequestBody Order_Details orderDetails) {

		System.out.println("ADD");

		return orderDetailsService.newOrderDetails(orderDetails);
	}

	@GetMapping("/orderDetails/{id}")
	public ResponseTemplateValueObject getOrderDetails(@PathVariable("id") Long orderDetailsId) {
		System.out.println("ID-1");
		return orderDetailsService.orderDetails(orderDetailsId);
	}
}
