package com.rk3.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rk3.springdemo.dao.CustomerDAO;
import com.rk3.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustommer(Model model) {
		List<Customer> customers = customerDAO.getCustomers();
		System.out.println(customers);
		model.addAttribute("customers", customers);
		return "list-customers";
	}
}
