package com.microservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {
	
	public Optional<Account> findByAccountNumber(Long accNumber);
}
