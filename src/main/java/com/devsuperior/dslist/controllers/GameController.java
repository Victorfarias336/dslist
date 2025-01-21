package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GamesDTO;
import com.devsuperior.dslist.dto.GamesMinDTO;
import com.devsuperior.dslist.services.GameServices;

@RestController
@RequestMapping(value = "/games")
public class GameController {

	@Autowired
	private GameServices gameServices;
	
	@GetMapping
	public List<GamesMinDTO> findAll(){
		List<GamesMinDTO> result = gameServices.findAll();
		return result;
	}
	@GetMapping(value = "/{id}")
	public GamesDTO findById(@PathVariable Long id){
		GamesDTO result = gameServices.findById(id);
		return result;
	}
}
