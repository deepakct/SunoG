package com.example.MI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MI.entity.Users;

public interface UserRepository  extends JpaRepository<Users,Integer>{
	
	public Users findByEmail(String email);
		
		
	

}
