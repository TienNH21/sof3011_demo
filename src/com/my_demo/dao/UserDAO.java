package com.my_demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;

import com.my_demo.entity.User;
import com.utils.EncryptUtils;
import com.utils.HibernateUtil;

public class UserDAO extends BaseDAO<User> {
	public UserDAO()
	{
	}
	
	public User login(String email, String pwd)
	{
		String hql = "FROM User WHERE email = :email";
		Query query = HibernateUtil.getSession().createQuery(hql, User.class);
		query.setParameter("email", email);
		
		List<User> results = query.getResultList();
		
		for (User user : results) {
			if (EncryptUtils.checkPass(pwd, user.getPassword())) {
				return user;
			}
		}
		
		return null;
	}

	@Override
	public String getBaseClass() {
		return User.class.getSimpleName();
	}

	@Override
	public Class<User> getFullClass() {
		return User.class;
	}
}
