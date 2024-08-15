package com.example.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entities.Song;
import com.example.springboot.entities.Users;

public interface SongRepository extends JpaRepository<Song,Integer> 
{
	public Song findByName(String name);

}
