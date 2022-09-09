package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mens_Stylish_ShoesDAO {
	@Autowired
	Mens_Stylish_ShoesRepo repo;
	
	//insert
	public Mens_Stylish_Shoes insert(Mens_Stylish_Shoes mr) {
		return repo.save(mr);
	}
	
	//get the data
	public List<Mens_Stylish_Shoes> getAll() {
		return repo.findAll();
	}
	
	//delete a row
	public void deleteById(String id) {
		repo.deleteById(id);
	}

	public Mens_Stylish_Shoes edit(String size, int quantity) {
		Mens_Stylish_Shoes mrmr = repo.findById(size).orElse(null); 
		mrmr.setQuantity(quantity);
		return repo.save(mrmr);
	}
	
	public Mens_Stylish_Shoes buy(String size) {
		Mens_Stylish_Shoes mrmr = repo.findById(size).orElse(null); 
		mrmr.setQuantity(mrmr.getQuantity()-1);
		return repo.save(mrmr);
	}
}

