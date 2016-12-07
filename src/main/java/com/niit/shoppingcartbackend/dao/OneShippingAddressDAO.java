package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.model.OneShippingAddress;

public interface OneShippingAddressDAO {

	public OneShippingAddress get(String id);
	public List<OneShippingAddress>  list();
	public boolean save(OneShippingAddress oneShippingAddress);
	public boolean update(OneShippingAddress oneShippingAddress);
	public boolean delete(OneShippingAddress oneShippingAddress);
	
}
