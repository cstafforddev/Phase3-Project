package com.example.demo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Womens_Running_ShoesDAO {
	@Autowired
	Womens_Running_ShoesRepo repo;
	Logger log = Logger.getAnonymousLogger();
	
	//insert
	public Womens_Running_Shoes insert(Womens_Running_Shoes wr) {
		return repo.save(wr);
	}
	
	//get the data
	public List<Womens_Running_Shoes> getAll() {
		return repo.findAll();
	}
	
	//delete a row
	public void deleteById(String id) {
		repo.deleteById(id);
	}

	public Womens_Running_Shoes edit(String size, int quantity) {
		Womens_Running_Shoes wrwr = repo.findById(size).orElse(null); 
		log.info("wrwr size:");
		log.info(wrwr.getSize());
		wrwr.setQuantity(quantity);
		return repo.save(wrwr);
	}
	
	public Womens_Running_Shoes buy(String size) {
		Womens_Running_Shoes wrwr = repo.findById(size).orElse(null); 
		wrwr.setQuantity(wrwr.getQuantity()-1);
		return repo.save(wrwr);
	}
}

