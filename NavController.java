package com.example.MI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

	
	@GetMapping("/map-register")
	public String mapregister() {
		return "register";
	}
	
	@GetMapping("/map-login")
	public String maplogin() {
		return "Login";
	}
	
	@GetMapping("/map-songs")
	public String mapsongs() {
		return "Songs";
	}
	
	
	
	@GetMapping("/SamplePayment")
	public String SamplePayment() {
		return "SamplePayment";
	}
	
	
	
}
