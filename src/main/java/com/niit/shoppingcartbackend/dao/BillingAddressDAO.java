package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.model.BillingAddress;

public interface BillingAddressDAO {

	public BillingAddress get(String id);
	public List<BillingAddress>  list();
	public boolean save(BillingAddress billingAddress);
	public boolean update(BillingAddress billingAddress);
	public boolean delete(BillingAddress billingAddress);
	
}
