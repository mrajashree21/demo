package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springboot.entities.Users;

import jakarta.servlet.http.HttpSession;

@Controller
public class NavController 
{
	@GetMapping("/map-register")
	public String registerMapping()
	{
		return "register";
	}
	
	@GetMapping("/map-login")
	public String loginMapping()
	{
		return "login";
	}
	
	@GetMapping("/map-songs")
	public String SongMapping()
	{
		return "addsongs";
	}
	
	@GetMapping("/samplepayment")
	public String SamplePayment()
	{
		return "samplepayment";
	}
	
	@GetMapping("/admin")
	public String adminHome()
	{
		return "adminhome";
	}
	
	
	
	
	

	
	
	
	

}
