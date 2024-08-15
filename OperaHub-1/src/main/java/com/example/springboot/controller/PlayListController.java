package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springboot.entities.PlayList;

import com.example.springboot.entities.Song;
import com.example.springboot.entities.Users;
import com.example.springboot.services.PlayListService;
import com.example.springboot.services.SongService;
import com.example.springboot.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PlayListController 
{
	
	@Autowired
	PlayListService pserv;
	
	@Autowired
	SongService sserv;
	
	@Autowired
	UsersService userv;
	

	@GetMapping("/map-playlist")
	public String createPlayList(HttpSession session,Model model) {
		
		
		String email=(String) session.getAttribute("email");
		Users user=userv.getUser(email);
		boolean userStatus=user.isPremium();
		
		
		if(userStatus==true)
		{
		

			//Fetching the songs using song service
			List<Song> songslist=sserv.fetchAllSongs();
			
			//Adding the songs in the model
			model.addAttribute("songslist",songslist);
			
			//sending createplaylist
			return "createplaylist";
			
		}
		else
		{
			return "payment";
		}
		
	}
	
	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute PlayList playlist) {
		
		
		
		
		//adding playlist
		pserv.addPlaylist(playlist);
		
		//update song table
		
		List<Song> songsList= playlist.getSongs();
		for(Song song : songsList) {
			song.getPlaylist().add(playlist);
			sserv.updateSong(song);
		}
		
		return "playlistsucess";
	}
	
	
	@GetMapping("/viewPlaylist")
	public String viewPlaylists(HttpSession session,Model model) {
		String email=(String) session.getAttribute("email");
		Users user=userv.getUser(email);
		boolean userStatus=user.isPremium();
		
		if(userStatus==true)
		{
		

			List<PlayList> plist= pserv.fetchPlaylists();
			 
			model.addAttribute("plist", plist);
			
			return "viewPlaylist";
			
		}
		else
		{
			return "payment";
		}
		
	}
	
}

