package com.rk3.springdemo.service;

import java.util.List;

import com.rk3.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	public void saveCustomer(Customer customer);
}
