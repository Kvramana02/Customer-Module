package com.cts.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.assignment.model.Customer;
import com.cts.assignment.repo.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> fetchCustomerList() {
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> fetchCustomerById(Long customerId) {

		return customerRepository.findById(customerId);
	}

	@Override
	public Customer updateCustomerAddress(Customer customer, Long customerId) {
		Customer cust = null;
		Optional<Customer> custDB = customerRepository.findById(customerId);
		if (custDB.isPresent()) {

			cust = custDB.get();
			cust.setCurrentAddress(customer.getCurrentAddress());

			return customerRepository.save(cust);
		} else {
			log.info("Customer details not found for id:", customerId);
		}
		return customer;

	}

	@Override
	public List<Customer> searchCustomer(Customer customer) {

		List<Customer> customers = customerRepository.searchByFirstAndOrLastName(customer.getFirstName(),
				customer.getLastName());
		if (!customers.isEmpty()) {
			return customers;
		} else {
			log.info("Customer details not found for first name and last name:");
			return new ArrayList<>();
		}
	}

}
