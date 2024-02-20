package com.example.MI.service;

import java.util.List;

import com.example.MI.entity.Songs;

public interface Sservice  {
	
	public String addSongs(Songs s);
	public boolean validateSong(Songs s);
	public List<Songs> showsongs();
	public void updateSong(Songs s);
	

}
