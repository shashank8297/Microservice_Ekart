package com.infinite.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.product.model.Product;
import com.infinite.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductComtroller {

	@Autowired
	ProductService productService;
	
	@PostMapping("/addProduct")
	public Product addNewProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	@GetMapping("/{id}")
	public Product productDetails(@PathVariable("id") Long productId) {
		return productService.findProductByProductId(productId);
	}
	
	@PostMapping("/remove/{id}")
	public String removeProduct(@PathVariable("id") Long productId) {
		productService.removeProductById(productId);
		Product po = new Product();
		String productName =  po.getProductName();
		String msg = productName+" is Removed";
		return msg;
	}
	
}
