package com.example.demo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminDAO {
	@Autowired
	AdminRepo repo;
	
	Logger log = Logger.getAnonymousLogger();
	
	//insert
	public Admin insert(Admin a) {
		return repo.save(a);
	}
	
	//get the data
	public List<Admin> getAll() {
		return repo.findAll();
	}
	
	//delete a row
	public void deleteById(String id) {
		repo.deleteById(id);
	}

	public Admin updatePassword(Admin a, String password) { 
		log.info(a.getPassword());
		a.setPassword(password);
		return repo.save(a);
	}
}

