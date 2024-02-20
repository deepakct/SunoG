package com.example.MI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MI.entity.Playlist;

public interface PLRepository extends JpaRepository<Playlist,Integer> {

}
