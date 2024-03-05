package com.infinite.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinite.product.model.Product;
import com.infinite.product.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

	@Autowired
	ProductRepository productRepository;
	
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	public Product findProductByProductId(Long productId) {
		// TODO Auto-generated method stub
		return productRepository.findById(productId).orElseThrow(IllegalArgumentException::new);
	}

	public void removeProductById(Long productId) {
		// TODO Auto-generated method stub
		productRepository.deleteById(productId);
	}

	@Override
	public List<Product> productList() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}
}
