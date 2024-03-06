package com.infinite.apicoudegatway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

	@GetMapping("/orderServiceFallBack")
	public String orderServiceFallBack() {
		return "Order Service is taking longer than excpeted."
				+ "Please Try Again Later....";
	}

	@GetMapping("/productServiceFallBack")
	public String productServiceFallBack() {
		return "Product Service is taking longer than excpeted."
				+ "Please Try Again Later....";
	}
	
	@GetMapping("/userServiceFallBack")
	public String userServiceFallBack() {
		return "User Service is taking longer than excpeted."
				+ "Please Try Again Later....";
	}
	
	@GetMapping("/orderDeatilsServiceFallBack")
	public String orderDetailsServiceFallBack() {
		return "Order Details Service is taking longer than excpeted."
				+ "Please Try Again Later....";
	}
}
