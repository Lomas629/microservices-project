package com.microservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private Long accountNumber;
	
	private Long amount;
	
	private String customerName;
	
}
