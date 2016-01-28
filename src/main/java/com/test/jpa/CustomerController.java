package com.test.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.service.base.CustomerService;

@RestController()
public class CustomerController {

	@Autowired
	CustomerRepository customerrepository;
	
	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/api/customer", method = RequestMethod.GET, produces = "application/json")
	public List<Customer> getCustomer() {
		return customerrepository.findAll();
	}

	@RequestMapping(value = "/api/customer", method = RequestMethod.POST, produces = "application/json")
	@Transactional
	public List<Customer> insertCustomer(@RequestBody Customer customer) throws Exception  {

		return customerService.insertCustomer(customer);
	}
	
	
	/*	Customer custom = customerrepository.save(customer);
		System.out.println(custom);
		if(custom!=null) {
			throw new Exception("Failed ");
		}
		List<Customer> customerList = customerrepository.findAll();
		
		return customerList;
	}*/

}
