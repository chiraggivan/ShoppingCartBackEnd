package com.niit.shoppingcartbackend.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.dao.ShippingAddressDAO;
import com.niit.shoppingcartbackend.model.ShippingAddress;


@Repository("shippingAddressDAO")
public class ShippingAddressDAOImpl implements ShippingAddressDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public ShippingAddressDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	
	}
		
	@Transactional
	public boolean save(ShippingAddress shippingAddress) {
		
		try {
			if (get(shippingAddress.getId()) != null)
			{
				return false;
			}
			Session session =sessionFactory.getCurrentSession();
			session.save(shippingAddress);
			session.flush();
			return true;
			
			} 
		catch (HibernateException e) 
			{
			e.printStackTrace();
			return false;
			}
		}
	
	@Transactional
	public boolean update(ShippingAddress shippingAddress) {
		
		try {
			if (get(shippingAddress.getId()) == null)
				{
				return false;
				}
			//sessionFactory.openSession().update(shippingAddress);
			Session session=sessionFactory.openSession();//.getCurrentSession();
			Transaction tx =session.beginTransaction();
			tx.begin();
			session.saveOrUpdate(shippingAddress);//update(category);
			tx.commit();
			session.flush();
			return true;
			}
		catch (HibernateException e) 
			{
			e.printStackTrace();
			return false;
			}
		
	}
	
	@Transactional
	public boolean delete(ShippingAddress shippingAddress) {
		
		try {
			if (get(shippingAddress.getId()) == null)
				{
				return false;
				}
			//sessionFactory.getCurrentSession().delete(shippingAddress);
			Session session=sessionFactory.openSession();
			Transaction tx =session.beginTransaction();
			tx.begin();
			session.delete(shippingAddress);
			tx.commit();
			session.flush();
			return true;
			} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public ShippingAddress get(String id) {
	
		return (ShippingAddress) sessionFactory.getCurrentSession().get(ShippingAddress.class, id);
	}

	@Transactional
	public List<ShippingAddress> list() {
		
		String hql = "from ShippingAddress";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	
	

}
