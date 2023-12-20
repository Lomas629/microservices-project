package com.microservice.payload;

import lombok.Data;

@Data
public class InputDetails {
	
	private Long accountNumber;
	
	private Long amount=0L;
	
	private Long customerId;

}
