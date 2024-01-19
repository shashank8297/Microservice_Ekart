package com.infinite.orders_details.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infinite.orders_details.model.*;
import com.infinite.orders_details.repository.Order_DetailsRepositoty;
import com.infinite.orders_details.valueobject.Orders;
import com.infinite.orders_details.valueobject.Product;
import com.infinite.orders_details.valueobject.ResponseTemplateValueObject;
import com.infinite.orders_details.valueobject.User;

@Service
public class Order_DetailsService implements IOder_Details {

	@Autowired
	Order_DetailsRepositoty oderDetailsRepositoty;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Order_Details newOrderDetails(Order_Details orderDetails) {
		// TODO Auto-generated method stub return
		return oderDetailsRepositoty.save(orderDetails);
	}

	public ResponseTemplateValueObject orderDetails(Long orderDetailsId) {
		// TODO Auto-generated method stub
		System.out.println("ID-2");
		ResponseTemplateValueObject vo = new ResponseTemplateValueObject();

		Order_Details orderDetails = oderDetailsRepositoty.findById(orderDetailsId)
				.orElseThrow(IllegalArgumentException::new);

		User user = restTemplate.getForObject("http://localhost:9001/user/" + orderDetails.getUserId(), User.class);

		Orders orders = restTemplate.getForObject("http://localhost:9003/orders/" + orderDetails.getOrderId(),
				Orders.class);
		
		Product product = restTemplate.getForObject("http://localhost:9002/product/" + orderDetails.getProductId(),
				Product.class);

		
		
		vo.setOrderDetails(orderDetails);
		vo.setUser(user);
		vo.setOrder(orders);
		vo.setProduct(product);
		return vo;
	}

}
