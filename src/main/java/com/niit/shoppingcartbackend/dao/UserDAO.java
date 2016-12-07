package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.model.User;

public interface UserDAO {

	public User get(String id);
	public List<User>  list();
	public boolean save(User user);
	public boolean update(User user);
	public boolean delete(User user);
	public boolean isValidUser(String id, String password);
		
}
