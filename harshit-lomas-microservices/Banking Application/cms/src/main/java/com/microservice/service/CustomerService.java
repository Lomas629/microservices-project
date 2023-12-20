package com.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.entity.Customer;
import com.microservice.payloads.CustomerDetails;
import com.microservice.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	public Customer addCustomer(CustomerDetails details) {
		Customer customer = new Customer();
		
		customer.setFirstname(details.getFirstname());
		customer.setLastname(details.getLastname());
		customer.setAccountNumber(details.getAccountNumber());
		customer.setGender(details.getGender());
		
		Customer c = repository.save(customer);
		
		return c;
		
	}
	
	public List<Customer> getAllRecords(){
		return repository.findAll();
	}
	
	public Customer getCustomerById(Long id) {
		return repository.findById(id).get();
	}
	
	public void deleteCustomerById(Long id) {
		repository.deleteById(id);
	}


}
