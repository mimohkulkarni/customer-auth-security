package com.mimoh.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mimoh.customer.modal.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	List<Customer> findByEmail(String email);
//
	List<Customer> findByFirstName(String firstName);
}
