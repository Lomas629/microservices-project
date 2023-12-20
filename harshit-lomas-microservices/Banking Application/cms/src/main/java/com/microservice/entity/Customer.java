package com.microservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String firstname;
	
	private String lastname;
	
	private Long accountNumber;
	
	private String gender;
	
}