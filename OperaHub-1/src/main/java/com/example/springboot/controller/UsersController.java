package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springboot.entities.Song;
import com.example.springboot.entities.Users;
import com.example.springboot.services.SongService;
import com.example.springboot.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
	
	@Autowired
	UsersService userv;
	
	
	@Autowired
	SongService sserv;
	
	
	
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user)
			
	{
		boolean userstatus=userv.emailExists(user.getEmail());
		if(userstatus==false)
		{
			userv.addUser(user);
			return "registersucess";
		}
		else
		{
		   return "registerfail";
		}
		
		
	}
	
	
	
	@PostMapping("/login")
	public String validateUser(@RequestParam String email, @RequestParam String password,HttpSession session,Model model)
	{
		
		//invoking validateUser() in service
		if(userv.validateUser(email, password)==true)
		{
			session.setAttribute("email", email);
			
			if(userv.getRole(email).equals("admin"))
			{
				return "adminhome";
			}
			else
			{
				
				return "customerhome";
			}
			
			
		}
		else
		{
			return "loginfail";
		}
	}
	
	
	
	@GetMapping("/exploreSongs")
	public String exploreSongs(HttpSession session,Model model)
	{
		String email=(String) session.getAttribute("email");
		Users user=userv.getUser(email);
		boolean userStatus=user.isPremium();
		if(userStatus==true)
		{
		
			List<Song>songslist=sserv.fetchAllSongs();
			model.addAttribute("songslist",songslist);


			return "displaysongs";
			
		}
		else
		{
			return "payment";
		}
		
		
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		
		return "index";
	}
	
	
	
	
	
	

}

