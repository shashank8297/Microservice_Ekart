package com.infinite.orders_details.valueobject;


public class Product {

	private Long productId;
	
	private String productName;
	
	private String productDec;
	
	private Long ProductPrice;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDec() {
		return productDec;
	}

	public void setProductDec(String productDec) {
		this.productDec = productDec;
	}

	public Long getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(Long productPrice) {
		ProductPrice = productPrice;
	}
}
