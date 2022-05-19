package com.rk3.springdemo.dao;

import java.util.List;

import com.rk3.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	public void saveCustomer(Customer customer);
}
