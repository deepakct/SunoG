package com.example.MI.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Songs {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	public 
	String name;
	String artist;
	String genre;
	String link;
	@ManyToMany
	List<Playlist> pl;
	public Songs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Songs(int id, String name, String artist, String genre, String link, List<Playlist> pl) {
		super();
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.genre = genre;
		this.link = link;
		this.pl = pl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public List<Playlist> getPl() {
		return pl;
	}
	public void setPl(List<Playlist> pl) {
		this.pl = pl;
	}
	@Override
	public String toString() {
		return "Songs [id=" + id + ", name=" + name + ", artist=" + artist + ", genre=" + genre + ", link=" + link
				+ "]";
	}
	
	
	

}
