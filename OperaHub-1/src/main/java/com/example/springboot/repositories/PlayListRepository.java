package com.example.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entities.PlayList;

public interface PlayListRepository extends JpaRepository<PlayList,Integer>{

}
