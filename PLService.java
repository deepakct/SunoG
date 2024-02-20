package com.example.MI.service;

import java.util.List;

import com.example.MI.entity.Playlist;

public interface PLService {

	public String addPlaylist(Playlist pl);

	public List<Playlist> showPL();

}
