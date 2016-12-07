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

import com.niit.shoppingcartbackend.dao.BillingAddressDAO;
import com.niit.shoppingcartbackend.model.BillingAddress;


@Repository("billingAddressDAO")
public class BillingAddressDAOImpl implements BillingAddressDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public BillingAddressDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	
	}
		
	@Transactional
	public boolean save(BillingAddress billingAddress) {
		System.out.println("trying to create new record for shipping address with new id"+billingAddress.getId());
		try {
			if (get(billingAddress.getId()) != null)
			{
				return false;
			}
			Session session =sessionFactory.getCurrentSession();
			session.save(billingAddress);
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
	public boolean update(BillingAddress billingAddress) {
		System.out.println("trying to check shipping id for update -- " + billingAddress.getId());
		try {
			if (get(billingAddress.getId()) == null)
				{
				return false;
				}
			Session session=sessionFactory.openSession();//.getCurrentSession();
			Transaction tx =session.beginTransaction();
			tx.begin();
			session.saveOrUpdate(billingAddress);//update(category);
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
	public boolean delete(BillingAddress billingAddress) {
		
		try {
			if (get(billingAddress.getId()) == null)
				{
				return false;
				}
			Session session=sessionFactory.openSession();
			Transaction tx =session.beginTransaction();
			tx.begin();
			session.delete(billingAddress);
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
	public BillingAddress get(String id) {
	
		return (BillingAddress) sessionFactory.getCurrentSession().get(BillingAddress.class, id);
	}

	@Transactional
	public List<BillingAddress> list() {
		
		String hql = "from BillingAddress";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	
	

}
