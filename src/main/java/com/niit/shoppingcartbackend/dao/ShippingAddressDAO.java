package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.model.ShippingAddress;

public interface ShippingAddressDAO {

	public ShippingAddress get(String id);
	public List<ShippingAddress>  list();
	public boolean save(ShippingAddress shippingAddress);
	public boolean update(ShippingAddress shippingAddress);
	public boolean delete(ShippingAddress shippingAddress);
		
}
