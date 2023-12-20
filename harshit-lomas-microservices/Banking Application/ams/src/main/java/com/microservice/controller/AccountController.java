package com.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.entity.Account;
import com.microservice.payload.CustomerResponse;
import com.microservice.payload.InputDetails;
import com.microservice.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService service;
	
	@Autowired
	private RestTemplate template;
	
	@PostMapping("/create")
	public Account create(@RequestBody InputDetails details) {
		String url = "http://customer-service/customer/"+details.getCustomerId();
		CustomerResponse customer = this.template.getForObject(url,CustomerResponse.class);
		return service.create(details, customer.getFirstname()+" "+customer.getLastname());
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addMoney(@RequestBody InputDetails details) {
		service.addMoney(details, "Harshit");
		return new ResponseEntity<>("Amount of "+details.getAmount()+" is added to account "+details.getAccountNumber(),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/withdraw")
	public ResponseEntity<String> withdrawMoney(@RequestBody InputDetails details){
		service.withdrawMoney(details, "Harshit");
		return new ResponseEntity<>("₹ "+details.getAmount()+" is debited from your account "+details.getAccountNumber(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{accountNumber}")
	public ResponseEntity<String> deleteAccount(@PathVariable("accountNumber") Long accNumber){
		service.deleteAccount(accNumber);
		return new ResponseEntity<>("Account "+accNumber+" is deleted",HttpStatus.ACCEPTED);
	}
	

}
