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

import com.niit.shoppingcartbackend.dao.UserDAO;
import com.niit.shoppingcartbackend.model.User;


@Repository("userDAO")
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	
	}
		
	@Transactional
	public boolean save(User user) {
		
		try {
			if (get(user.getId()) != null)
			{
				return false;
			}
			Session session =sessionFactory.getCurrentSession();
			session.save(user);
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
	public boolean update(User user) {
		
		try {
			if (get(user.getId()) == null)
				{
				return false;
				}
			Session session=sessionFactory.openSession();//.getCurrentSession();
			Transaction tx =session.beginTransaction();
			tx.begin();
			session.saveOrUpdate(user);//update(category);
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
	public boolean delete(User user) {
		
		try {
			if (get(user.getId()) == null)
				{
				return false;
				}
			Session session=sessionFactory.openSession();
			Transaction tx =session.beginTransaction();
			tx.begin();
			session.delete(user);
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
	public User get(String id) {
	
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Transactional
	public List<User> list() {
		
		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public boolean isValidUser(String id, String password){
		List<User> u;
		
		String hql = "from User where id='"+id+"' and password='"+password+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		u=query.list();
		if(!(u.isEmpty()))
		{
		return true;
		}
		else
		{
			return false; 
			
		}
	}
	

}
