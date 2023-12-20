package com.microservice.payload;

import lombok.Data;

@Data
public class CustomerResponse {
	
	private Long Id;
	
	private String firstname;
	
	private String lastname;
	
	private Long accountNumber;
	
	private String gender;

}
