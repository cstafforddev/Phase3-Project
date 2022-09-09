package com.example.demo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
                                    
public interface AdminRepo extends JpaRepository<Admin, String> {
	@Query("select admin from Admin admin where admin.email=?1")
	public User findbyemail(String email);
}
