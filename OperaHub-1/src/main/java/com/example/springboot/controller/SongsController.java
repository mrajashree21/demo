package com.example.springboot.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springboot.entities.Song;
import com.example.springboot.entities.Users;
import com.example.springboot.services.SongService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SongsController 
{
	@Autowired
	SongService sserv;
	@PostMapping("/songs")
	public String addSongs(@ModelAttribute Song song)
	{
		
		boolean songstatus=sserv.songExists(song.getName());
		if(songstatus==false)
		{
			String msg=sserv.addSongs(song);
			return "songsucess";
		}
		else
		{
		   return "songfail";
		}
		
	}
	@GetMapping("/map-viewsongs")
	public String viewSongs(Model model)
	{
		List<Song>songslist=sserv.fetchAllSongs();
		model.addAttribute("songslist",songslist);

		return "displaysongs";
		
		
	}
	
	
	
	
	

}
