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

import com.niit.shoppingcartbackend.dao.SupplierDAO;
import com.niit.shoppingcartbackend.model.Supplier;


@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	
	}
		
	@Transactional
	public boolean save(Supplier supplier) {
		
		try {
			if (get(supplier.getId()) != null)
			{
				return false;
			}
			Session session =sessionFactory.getCurrentSession();
			session.save(supplier);
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
	public boolean update(Supplier supplier) {
		
		try {
			if (get(supplier.getId()) == null)
				{
				return false;
				}
			Session session=sessionFactory.openSession();//.getCurrentSession();
			Transaction tx =session.beginTransaction();
			tx.begin();
			session.update(supplier);//update(category);
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
	public boolean delete(Supplier supplier) {
		
		try {
			if (get(supplier.getId()) == null)
				{
				return false;
				}
			Session session=sessionFactory.openSession();
			Transaction tx =session.beginTransaction();
			tx.begin();
			session.delete(supplier);
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
	public Supplier get(String id) {
	
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, id);
	}

	@Transactional
	public List<Supplier> list() {
		
		String hql = "from Supplier";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	
	

}
