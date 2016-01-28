package com.test.service.base;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.test.jpa.Customer;

public interface CustomerService {
	public Customer save(Customer customer);
	public List<Customer> insertCustomer(@RequestBody Customer customer) throws Exception;
}
