package com.microservice.payloads;

import lombok.Data;

@Data
public class AccountDetails {
	
	private Long accountNumber;
	
	private Long amount=0L;
	
	private Long customerId;


}
