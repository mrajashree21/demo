package com.example.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entities.Song;
import com.example.springboot.repositories.SongRepository;

@Service
public class SongServiceImplementation implements SongService {

	@Autowired
	SongRepository songrepo;
	@Override
	public String addSongs(Song song) {
		songrepo.save(song);
		return "song is added and saved";
		
	}
	@Override
	public boolean songExists(String name) {
		if(songrepo.findByName(name)==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	@Override
	public List<Song> fetchAllSongs() {
		List<Song> songlist=songrepo.findAll();
		return songlist;
	}
	@Override
	public void updateSong(Song song) {
		songrepo.save(song);
		
	}
	

}
