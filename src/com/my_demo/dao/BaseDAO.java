package com.my_demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.utils.HibernateUtil;

abstract public class BaseDAO<T> {
	public BaseDAO()
	{
	}
	
	abstract public String getBaseClass();
	abstract public Class<T> getFullClass();
	
	public T create(T entity)
	{
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<T> paginate(int limit, int offset)
	{
		try {
			Session session = HibernateUtil.getSession();
			Query query = session.createQuery("FROM " + this.getBaseClass());
			query.setFirstResult(offset);
			query.setMaxResults(offset + limit);
			List results = query.getResultList();
			return results;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<T> getAll()
	{
		try {
			Session session = HibernateUtil.getSession();
			Query query = session.createQuery("FROM " + this.getBaseClass());
			List results = query.getResultList();
			return results;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public T find(int id)
	{
		try {
			Session session = HibernateUtil.getSession();
			T entity =  (T) session.get(this.getFullClass(), id);
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void update(T entity)
	{
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			session.update(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(T entity)
	{
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
