package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Womens_Stylish_ShoesDAO {
	@Autowired
	Womens_Stylish_ShoesRepo repo;
	
	//insert
	public Womens_Stylish_Shoes insert(Womens_Stylish_Shoes wr) {
		return repo.save(wr);
	}
	
	//get the data
	public List<Womens_Stylish_Shoes> getAll() {
		return repo.findAll();
	}
	
	//delete a row
	public void deleteById(String id) {
		repo.deleteById(id);
	}

	public Womens_Stylish_Shoes edit(String size, int quantity) {
		Womens_Stylish_Shoes mrmr = repo.findById(size).orElse(null); 
		mrmr.setQuantity(quantity);
		return repo.save(mrmr);
	}
	
	public Womens_Stylish_Shoes buy(String size) {
		Womens_Stylish_Shoes mrmr = repo.findById(size).orElse(null); 
		mrmr.setQuantity(mrmr.getQuantity()-1);
		return repo.save(mrmr);
	}
}

