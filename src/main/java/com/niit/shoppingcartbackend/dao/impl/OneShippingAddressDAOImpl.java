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

import com.niit.shoppingcartbackend.dao.OneShippingAddressDAO;
import com.niit.shoppingcartbackend.model.OneShippingAddress;


@Repository("oneShippingAddressDAO")
public class OneShippingAddressDAOImpl implements OneShippingAddressDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public OneShippingAddressDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	
	}
		
	@Transactional
	public boolean save(OneShippingAddress oneShippingAddress) {
		System.out.println("trying to create new record for shipping address with new id");
		try {
			if (get(oneShippingAddress.getId()) != null)
			{
				return false;
			}
			Session session =sessionFactory.getCurrentSession();
			session.save(oneShippingAddress);
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
	public boolean update(OneShippingAddress oneShippingAddress) {
		System.out.println("trying to check shipping id for update -- " + oneShippingAddress.getId());
		try {
			if (get(oneShippingAddress.getId()) == null)
				{
				return false;
				}
			Session session=sessionFactory.openSession();//.getCurrentSession();
			Transaction tx =session.beginTransaction();
			tx.begin();
			session.saveOrUpdate(oneShippingAddress);//update(category);
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
	public boolean delete(OneShippingAddress oneShippingAddress) {
		
		try {
			if (get(oneShippingAddress.getId()) == null)
				{
				return false;
				}
			Session session=sessionFactory.openSession();
			Transaction tx =session.beginTransaction();
			tx.begin();
			session.delete(oneShippingAddress);
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
	public OneShippingAddress get(String id) {
	
		return (OneShippingAddress) sessionFactory.getCurrentSession().get(OneShippingAddress.class, id);
	}

	@Transactional
	public List<OneShippingAddress> list() {
		
		String hql = "from OneShippingAddress";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	
	

}
