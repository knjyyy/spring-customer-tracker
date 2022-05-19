package com.rk3.springdemo.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rk3.springdemo.dao.CustomerDAO;
import com.rk3.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer", Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}

}