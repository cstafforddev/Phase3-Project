package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAO {
	@Autowired
	UserRepo repo;
	
	//insert
	public User insert(User u) {
		return repo.save(u);
	}
	
	//get the data
	public List<User> getAll() {
		return repo.findAll();
	}
	
	//delete a row
	public void deleteById(String id) {
		repo.deleteById(id);
	}

	public User updateName(User u) {
		User uu = repo.findById(u.getEmail()).orElse(null); 
		uu.setName(u.getName());
		return repo.save(uu);
	}
}
