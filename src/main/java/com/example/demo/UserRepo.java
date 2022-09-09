package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
                                    
public interface UserRepo extends JpaRepository<User, String> {
	@Query("select user from User user where user.email=?1")
	public User findbyemail(String email);
}
