package com.example.MI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.MI.entity.Playlist;
import com.example.MI.entity.Songs;
import com.example.MI.service.PLService;
import com.example.MI.service.Sservice;

@Controller
public class PLController {
	
	
	@Autowired
	Sservice ss;
	

	@Autowired
	PLService ps;
	
	
	
	@GetMapping("/AddPlaylist")
	public String addPlayList(Model model) {
		
		List<Songs> pl=ss.showsongs();
		model.addAttribute("pl", pl);
		return "AddPlayList";
		
	}
	
	@PostMapping("/GetPlaylist")
	public String playList(@ModelAttribute Playlist pl) {
		
		
		System.out.println(pl);
		
		ps.addPlaylist(pl);
		
		List<Songs> plset=pl.getSongs();
		
		System.out.println(plset);
		
		
		for(Songs s:plset) {
			s.getPl().add(pl);
			ss.updateSong(s);
			
			
		}
		
		
		
		return "PLAdded";
	}
	
	
	@GetMapping("/showPlayList")
	public String showPL(Model model) {
		List<Playlist> pl=ps.showPL();
		System.out.println(pl);
		model.addAttribute("pl", pl);
		return "ShowPL";
 	}

}
