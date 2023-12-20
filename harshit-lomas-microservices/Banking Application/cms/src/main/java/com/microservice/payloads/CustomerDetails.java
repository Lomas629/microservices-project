package com.microservice.payloads;

import lombok.Data;

@Data
public class CustomerDetails {
	
	private String firstname;
	private String lastname;
	private Long accountNumber;
	private String gender;

}