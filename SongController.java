package com.example.MI.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.MI.entity.Songs;
import com.example.MI.service.Sservice;





@Controller
public class SongController {
	
	
	@Autowired
	Sservice ss;
	
	@PostMapping("/AddSongs")
	public String addsongs(@ModelAttribute Songs s) {
		
		if(ss.validateSong(s)==false) {
		
		ss.addSongs(s);
		
		return "SongSuccess";
		}
		else {
			return "SongAddFail";
		}
	}
	
	@GetMapping("/showSongs")
	public String showSongsList(Model model) {
		List<Songs> songslist=ss.showsongs();
		System.out.println(songslist);
		model.addAttribute("reslist", songslist);
		return "SongsList";
			
		
	}
	
	

}
