package com.example.demo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Mens_Stylish_Shoes {
	@Id
	private String size;
	private int quantity;

}
