package com.example.MI.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.MI.entity.Songs;
import com.example.MI.entity.Users;
import com.example.MI.service.Sservice;
import com.example.MI.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller

public class MIController {
	
	@Autowired
	UserService us;
	
	@Autowired
	Sservice ss;
	
	

	@PostMapping("/register")
	public String addUser(@ModelAttribute Users u) {
		
		if(us.emailExist(u.getEmail())) {
			System.out.println("The user is already exist");
			return "RegisterFailed";
		}
		else {
			us.addUser(u);
			return "RegisterSuccess";
		}
		
		
	}
	
	
	@PostMapping("/login")
	public String validateuser(@RequestParam String email,@RequestParam String password, HttpSession session,Model model) {
		
		boolean res=us.validateusers(email, password);
		String role=us.getRole(email);
		
		if(res==true) {
			
			session.setAttribute("email", email);
			if(role.equals("admin")) {
				
			
			return "AdminHome";
			}
			else {
				
				Users u=us.getUser(email);
				boolean status=u.isPremium();
				List<Songs> songslist=ss.showsongs();
				//System.out.println(songslist);
				model.addAttribute("reslist", songslist);
				model.addAttribute("UStatus", status);
				return "UserHome";
				
				/*
				 Users user = service.getUser(email);
				boolean userStatus = user.isPremium();
				List<Song> songsList = songService.fetchAllSongs();
				model.addAttribute("songs", songsList);
				
				model.addAttribute("isPremium", userStatus);
				 */
			}
			
		}
		else {
			return "LoginFailed";
		}
		
		
	}
	
	
	@GetMapping("/view-songs")
	public String status(HttpSession session,Model model) {
		
		String email=(String) session.getAttribute("email");
		Users u=us.getUser(email);
		boolean status=u.isPremium();
		
		if(status==true) {
			
			List<Songs> songslist=ss.showsongs();
			System.out.println(songslist);
			model.addAttribute("reslist", songslist);
			
			return "SongsList";
		}
		else {
			return "Makepayment";
			}
		
		
	}
	
	
}
