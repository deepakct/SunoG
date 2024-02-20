package com.example.MI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MI.entity.Playlist;
import com.example.MI.repository.PLRepository;

@Service
public class PLServiceImplementation implements PLService {
	
	
	@Autowired
	PLRepository plr;

	@Override
	public String addPlaylist(Playlist pl) {
		plr.save(pl);
		
		return "Success";
	}

	@Override
	public List<Playlist> showPL() {
		List<Playlist> pl=plr.findAll();
		return pl;
	}

}
