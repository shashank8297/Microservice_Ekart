package com.infinite.product.service;

import java.util.List;

import com.infinite.product.model.Product;

public interface IProductService {

	public Product addProduct(Product product);
	
	public Product findProductByProductId(Long productId);
	
	public void removeProductById(Long productId);
	
	public List<Product> productList();
}
