package com.example.MI.service;

import com.example.MI.entity.Users;

public interface UserService {
	
	public String addUser(Users u);
	
	public boolean emailExist(String email);
	public boolean validateusers(String email,String password);
	public String getRole(String email);
//	public boolean isPremiumStatus(String email);
	public Users getUser(String email);

	public void updateUser(Users u);

}
