package com.mimoh.customer.service;

import java.util.List;
import java.util.Optional;

import com.mimoh.customer.modal.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();
	
	public Customer getCustomer(int theId);
	
	public Customer saveCustomer(Customer employee);
	
	public void deleteCustomer(int theId);
	
	public List<Customer> findByFirstName(String name);

	public List<Customer> findByEmail(String email);
	
	public Optional<Customer> findById(int id);
}
