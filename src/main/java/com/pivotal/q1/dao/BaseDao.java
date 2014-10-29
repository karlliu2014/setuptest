package com.pivotal.q1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao {
	@Autowired
	protected SessionFactory sessionFactory;
	
	protected Session	getCurrentSession()	{
		return sessionFactory.getCurrentSession();
	}
}
