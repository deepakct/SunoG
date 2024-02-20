package com.example.MI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MI.entity.Songs;
import com.example.MI.repository.SongRepository;

@Service
public class SSImplementation implements Sservice {
	
	
	@Autowired
	SongRepository sr;

	@Override
	public String addSongs(Songs s) {
		sr.save(s);
		return "song added";
	}

	@Override
	public boolean validateSong(Songs s) {
		if(sr.findByName(s.getname())==null) {
			return false;
		}
		else {
			return true ;
			
		}
		
	}

	@Override
	public List<Songs> showsongs() {
		List<Songs> sl=sr.findAll();
		return sl;
	}

	@Override
	public void updateSong(Songs s) {
		sr.save(s);
		
	}

}
