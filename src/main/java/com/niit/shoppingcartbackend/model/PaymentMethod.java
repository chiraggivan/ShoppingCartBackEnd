package com.niit.shoppingcartbackend.model;

import java.io.Serializable;

public class PaymentMethod implements Serializable{

	private String paymentMethod;

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
}
