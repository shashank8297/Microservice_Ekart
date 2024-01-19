package com.infinite.orders_details.service;

import com.infinite.orders_details.model.Order_Details;
import com.infinite.orders_details.valueobject.ResponseTemplateValueObject;

public interface IOder_Details {

	public Order_Details newOrderDetails (Order_Details orderDetails);
	
	public ResponseTemplateValueObject orderDetails(Long orderDetailsId);
}
