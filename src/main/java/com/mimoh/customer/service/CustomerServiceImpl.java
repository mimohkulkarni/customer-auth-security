package com.mimoh.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mimoh.customer.modal.Customer;
import com.mimoh.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomer(int theId) {
		Optional<Customer> result = customerRepository.findById(theId);
		
		Customer customer = null;
		if(result.isPresent()) {
			customer = result.get();
		}
		else {
			throw new RuntimeException("Did not find employee with id "+ theId);
		}
		return customer;
	}

	@Override
	public Customer saveCustomer(Customer employee) {
		return customerRepository.save(employee);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerRepository.deleteById(theId);
	}

	@Override
	public List<Customer> findByFirstName(String name) {
		return customerRepository.findByFirstName(name);
	}

	@Override
	public List<Customer> findByEmail(String email) {
		return customerRepository.findByEmail(email);
	}

	@Override
	public Optional<Customer> findById(int id) {
		return customerRepository.findById(id);
	}

}
