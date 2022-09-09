package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Entity
@Service
public class User {
	private String name;
	private String password;
	@Id
	private String email;
	
	public String toString() {
		return name;
	}
}
