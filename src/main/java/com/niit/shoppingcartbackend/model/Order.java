package com.niit.shoppingcartbackend.model;

import java.io.Serializable;
import java.util.UUID;

public class Order implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	private String userID;
	
	private String orderID;
	
	private ShippingAddress shippingAddress;
	private BillingAddress billingAddress;
	
	//private Cart cart;
	private long totalAmount;
	
	private String paymentMethod;
	
	public Order()
	{
		this.orderID = "SHP_CRT_ORD_" + UUID.randomUUID();
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	/*public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}*/

	public long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
