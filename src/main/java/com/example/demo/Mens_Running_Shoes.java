package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Mens_Running_Shoes {
	@Id
	private String size;
	private int quantity;

}
