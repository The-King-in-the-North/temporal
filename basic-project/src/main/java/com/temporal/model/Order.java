package com.temporal.model;




public class Order {

	String productId;
	String productName;
	String unitPrice;
	String quantity;
	String paymentDetails;
	
	
	
	public Order(String productId, String productName, String unitPrice, String quantity, String paymentDetails) {
		this.productId = productId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.paymentDetails = paymentDetails;
	}
	
	public Order() {
		this.productId = "";
		this.productName = "";
		this.unitPrice = "";
		this.quantity = "";
		this.paymentDetails = "";
	}

	public String getProductId() {
		return paymentDetails;
	}
	public String getProductName() {
		return productName;
	}
	public String getUnitPrice() {
	return unitPrice;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setPaymentDetails(String paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	
	

}
