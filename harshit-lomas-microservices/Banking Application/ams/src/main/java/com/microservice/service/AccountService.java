package com.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.entity.Account;
import com.microservice.payload.AccountDetails;
import com.microservice.payload.InputDetails;
import com.microservice.repository.AccountRepository;


@Service
public class AccountService {
	
	@Autowired
	private AccountRepository repository;
	
	
	public void addMoney(InputDetails details,String customerName) {
		Account account = new Account();
		
		account.setAccountNumber(details.getAccountNumber());
		account.setAmount(details.getAmount());
		account.setCustomerName(customerName);
		
		repository.save(account);
	}
	
	public void withdrawMoney(InputDetails details,String customerName) {
		Account account = new Account();
		
		account.setAccountNumber(details.getAccountNumber());
		account.setAmount(details.getAmount());
		account.setCustomerName(customerName);
		
		repository.save(account);
	}
	
	public AccountDetails getAccountDetails(InputDetails details) {
		AccountDetails accountDetails = new AccountDetails();
		
		accountDetails.setAccountNumber(details.getAccountNumber());
		accountDetails.setAmount(details.getAmount());
		
		return accountDetails;
	}
	
	public void deleteAccount(Long id) {
		Account account = repository.findByAccountNumber(id).get();
		repository.delete(account);
	}

	public Account create(InputDetails details, String customerName) {
		Account account = new Account();
		
		account.setAccountNumber(details.getAccountNumber());
		account.setAmount(details.getAmount());
		account.setCustomerName(customerName);
		
		repository.save(account);
		
		return account;
	}

}
