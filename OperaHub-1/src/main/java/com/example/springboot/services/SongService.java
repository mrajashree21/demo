package com.example.springboot.services;



import java.util.List;

import com.example.springboot.entities.PlayList;
import com.example.springboot.entities.Song;

public interface SongService 
{
	public String addSongs(Song song);
	public boolean songExists(String name);
	public List<Song> fetchAllSongs();
	public void updateSong(Song song);



}
