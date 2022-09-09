package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Entity
@Service
public class Admin {
	@Id
	private String email;
	private String password;
}
