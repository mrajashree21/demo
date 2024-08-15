package com.example.springboot.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entities.Users;


public interface UsersRepository  extends JpaRepository<Users,Integer>
{

	
	public Users findByEmail(String email);
	

	




}
