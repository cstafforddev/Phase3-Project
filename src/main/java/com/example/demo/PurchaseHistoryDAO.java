package com.example.demo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseHistoryDAO {
	@Autowired
	PurchaseHistoryRepo repo;
	Logger log = Logger.getAnonymousLogger();
	
	//insert
	public PurchaseHistory insert(PurchaseHistory ph) {
		return repo.save(ph);
	}
	
	//get the data
	public List<PurchaseHistory> getAll() {
		return repo.findAll();
	}
	
	//delete a row
	public void deleteById(String id) {
		repo.deleteById(id);
	}
	
	public PurchaseHistory add(String category, String size, String name, String email, String date) {
		PurchaseHistory ph = new PurchaseHistory();
		ph.setCategory(category);
		ph.setSize(size);
		ph.setName(name);
		ph.setEmail(email);
		ph.setDate(date);
		log.info(ph.toString());
		return repo.save(ph);
	}

}

