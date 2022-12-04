package com.cts.assignment.service;

import java.util.List;
import java.util.Optional;

import com.cts.assignment.model.Customer;

public interface CustomerService {

	// Save customer
	Customer saveCustomer(Customer customer);

	// Read all customers
	List<Customer> fetchCustomerList();

	// Read Customer by ID
	Optional<Customer> fetchCustomerById(Long customerId);

	// Update customer Address
	Customer updateCustomerAddress(Customer customer, Long customerId);

	// Search Customer
	List<Customer> searchCustomer(Customer customer);

}
