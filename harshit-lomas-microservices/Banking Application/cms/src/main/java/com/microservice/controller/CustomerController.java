package com.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.entity.Customer;
import com.microservice.payloads.AccountDetails;
import com.microservice.payloads.CustomerDetails;
import com.microservice.service.CustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@Autowired
	private RestTemplate template;
	
	
	@PostMapping("/add")
	public ResponseEntity<String> addCustomer(@RequestBody CustomerDetails details){
		AccountDetails accountDetails = new AccountDetails();
		Customer c = this.service.addCustomer(details);
		
		accountDetails.setAccountNumber(details.getAccountNumber());
		accountDetails.setCustomerId(c.getId());
		
		this.template.postForObject("http://account-service/account/create",accountDetails , AccountDetails.class);
		
		
		return new ResponseEntity<>("Customer is added !!",HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		List<Customer> customers = this.service.getAllRecords();
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
	}
	
    @GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
		Customer customer = this.service.getCustomerById(id);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
		this.service.deleteCustomerById(id);
		return new ResponseEntity<>("Customer is deleted !!",HttpStatus.OK);
	}
	
}
