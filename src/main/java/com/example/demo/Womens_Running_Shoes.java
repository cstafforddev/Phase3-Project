package com.example.demo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Womens_Running_Shoes {
	@Id
	private String size;
	private int quantity;

}
