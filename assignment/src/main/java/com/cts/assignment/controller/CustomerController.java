package com.cts.assignment.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.assignment.model.Customer;
import com.cts.assignment.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/customers")
@Validated
@Slf4j
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/addCustomer")
	public Customer saveDepartment(@Valid @RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@GetMapping("/getAll")
	public List<Customer> fetchCustomerList() {
		return customerService.fetchCustomerList();
	}

	@GetMapping("get/{id}")
	public Customer fetchCustomerById(@PathVariable("id") Long customerId) {

		Optional<Customer> customer = customerService.fetchCustomerById(customerId);
		if (!customer.isEmpty()) {
			return customer.get();
		} else {
			log.info("Customer not found for id:", customerId);
		}
		return null;
	}

	@PutMapping("update/{id}")
	public Customer updateCustomerAddress(@RequestBody Customer customer, @PathVariable("id") Long customerId) {
		return customerService.updateCustomerAddress(customer, customerId);
	}

	@PostMapping("/searchCustomer")
	public List<Customer> searchCustomer(@Valid @RequestBody Customer customer) {
		return customerService.searchCustomer(customer);
	}
}
