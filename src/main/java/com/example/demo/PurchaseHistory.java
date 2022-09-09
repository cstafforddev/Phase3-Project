package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PurchaseHistory {
	private String category;
	private String size;
	private String name;
	private String email;
	@Id
	private String date;
}
