package com.example.nikhilbharatV3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nikhilbharatV3.model.User;



public interface UserRepository extends JpaRepository<User, Integer> {

//	User findByusername(String username);
	 
	User findByemail(String email);



}
