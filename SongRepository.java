package com.example.MI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MI.entity.Songs;

public interface SongRepository extends JpaRepository<Songs,Integer>{
	
	public Songs findByName(String name);

}
