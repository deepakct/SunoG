package com.example.MI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MI.entity.Users;
import com.example.MI.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{
	
	
	
	@Autowired
	UserRepository ur;

	@Override
	public String addUser(Users u) {
		ur.save(u);
		
		
		return "User created and stored into DataBase";
	}

	@Override
	public boolean emailExist(String email) {
		if(ur.findByEmail(email)==null) {
			return false;
		}
		else {
			return true;
		}
		
		
	}

	@Override
	public boolean validateusers(String email, String password) {
		
		Users u1=ur.findByEmail(email);
		String db_password=u1.getPassword();	
		
		if(db_password.equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String getRole(String email) {
		Users u=ur.findByEmail(email);
		String role=u.getRole();
		return role;
	}

	@Override
	public Users getUser(String email) {
		
		
		return ur.findByEmail(email);
		
		
	}

	@Override
	public void updateUser(Users u) {
		ur.save(u);
		
	}

	
	

	
	
	

}
