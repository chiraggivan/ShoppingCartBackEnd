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

import com.niit.shoppingcartbackend.dao.ProductDAO;
import com.niit.shoppingcartbackend.model.Product;


@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	
	}
		
	@Transactional
	public boolean save(Product product) {
		
		try {
			if (get(product.getId()) != null)
			{
				return false;
			}
			//sessionFactory.getCurrentSession().save(product);
			Session session =sessionFactory.getCurrentSession();
			session.save(product);
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
	public boolean update(Product product) {
		
		try {
			if (get(product.getId()) == null)
				{
				return false;
				}
			//sessionFactory.openSession().update(product);
			Session session=sessionFactory.openSession();//.getCurrentSession();
			Transaction tx =session.beginTransaction();
			tx.begin();
			session.saveOrUpdate(product);//update(category);
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
	public boolean delete(Product product) {
		
		try {
			if (get(product.getId()) == null)
				{
				return false;
				}
			//sessionFactory.getCurrentSession().delete(product);
			Session session=sessionFactory.openSession();
			Transaction tx =session.beginTransaction();
			tx.begin();
			session.delete(product);
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
	public Product get(String id) {
	
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}

	@Transactional
	public List<Product> list() {
		
		String hql = "from Product";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	
	

}
