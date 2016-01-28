package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.test.customException.CustomerException;
import com.test.jpa.Customer;
import com.test.jpa.CustomerRepository;
import com.test.service.base.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired(required=true)
	CustomerRepository customerRepository;
	
	/*@Autowired
	CategoryRepository categoryRepository;*/

	@Transactional
	public Customer save(Customer customer) {
		Customer customerExist = customerRepository.findOne(customer.getId());
		if (customerExist == null) {
			customerRepository.save(customer);
		}
		return customer;
	}
	
	@Override
	@Transactional(rollbackFor={Exception.class,CustomerException.class})
	public List<Customer> insertCustomer(@RequestBody Customer customer) throws Exception  {

		Customer custom = customerRepository.save(customer);
		System.out.println(custom);
		if(custom==null) {
			throw new CustomerException("Failed to save");
		}
		List<Customer> customerList = customerRepository.findAll();
		
		return customerList;
	}

}
