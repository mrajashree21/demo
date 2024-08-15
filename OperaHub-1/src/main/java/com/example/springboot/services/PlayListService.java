package com.example.springboot.services;



import java.util.List;

import com.example.springboot.entities.PlayList;


public interface PlayListService 
{

	

	

	

	public void addPlaylist(PlayList playlist);

	List<PlayList> fetchPlaylists();
	


	

}
