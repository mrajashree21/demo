package com.example.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entities.PlayList;
import com.example.springboot.entities.Song;
import com.example.springboot.repositories.PlayListRepository;


@Service
public class PlayListServiceImplementation implements PlayListService{

	
	@Autowired
	PlayListRepository playrepo;

	

	

	@Override
	public void addPlaylist(PlayList playlist) {
	    
		playrepo.save(playlist);
		
	}

	@Override
	public List<PlayList> fetchPlaylists() {
	
		return playrepo.findAll();
	}
	

	

}
