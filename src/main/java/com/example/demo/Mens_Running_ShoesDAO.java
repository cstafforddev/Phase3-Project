package com.example.demo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mens_Running_ShoesDAO {
	@Autowired
	Mens_Running_ShoesRepo repo;
	Logger log = Logger.getAnonymousLogger();
	
	//insert
	public Mens_Running_Shoes insert(Mens_Running_Shoes mr) {
		return repo.save(mr);
	}
	
	//get the data
	public List<Mens_Running_Shoes> getAll() {
		return repo.findAll();
	}
	
	//delete a row
	public void deleteById(String id) {
		repo.deleteById(id);
	}

	public Mens_Running_Shoes edit(String size, int quantity) {
		log.info(size);
		Mens_Running_Shoes mrmr = repo.findById(size).orElse(null); 
		mrmr.setQuantity(quantity);
		log.info("quantity updated");
		return repo.save(mrmr);
	}
	
	public Mens_Running_Shoes buy(String size) {
		Mens_Running_Shoes mrmr = repo.findById(size).orElse(null); 
		mrmr.setQuantity(mrmr.getQuantity()-1);
		return repo.save(mrmr);
	}
}

