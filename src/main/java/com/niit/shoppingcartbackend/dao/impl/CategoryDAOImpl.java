package com.niit.shoppingcartbackend.dao.impl;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.model.Category;
import com.niit.shoppingcartbackend.dao.CategoryDAO;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryDAOImpl (SessionFactory sessionFactory){
		
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean save(Category category) {
		
				
		try{
			if (get(category.getId()) != null)
			{
				return false;
			}
			Session session =sessionFactory.getCurrentSession();
			session.save(category);
			session.flush();
						
			return true;
			
		} catch (HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Category category) {
		
		try{
			if (get(category.getId()) == null)
			{
				return false;

			}
				System.out.println(category.getId());
				Session session=sessionFactory.openSession();//.getCurrentSession();
				Transaction tx =session.beginTransaction();
				tx.begin();
				session.saveOrUpdate(category);//update(category);
				tx.commit();
				session.flush();
				System.out.println(category.getDescription());
				return true;

		} catch (HibernateException e){
			e.printStackTrace();
			return false;
		}
		
	}

	@Transactional
	public boolean delete(Category category) {

		try{
			if (get(category.getId()) == null)
			{
				return false;
			}
			//sessionFactory.getCurrentSession().delete(category);
			Session session=sessionFactory.openSession();
			Transaction tx =session.beginTransaction();
			tx.begin();
			session.delete(category);
			tx.commit();
			session.flush();
			System.out.println("item removed by impl");
			return true;
			
		} catch (HibernateException e){
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Category get(String id) {
		
		System.out.println("get process started in impl");
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
		/*Category catg = new Category();
		Session session=sessionFactory.openSession();
		Transaction tx =session.beginTransaction();
		tx.begin();
		catg = (Category)session.get(Category.class, id);
		tx.commit();
		session.flush();
		return catg;*/
	}
	
	@Transactional 
	public java.util.List<Category> list() {
		
		String hql = "from Category";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}
		
}
