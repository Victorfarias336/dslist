package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GamesListDTO;
import com.devsuperior.dslist.services.GameListServices;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	@Autowired
	private GameListServices gameListServices;
	
	@GetMapping
	public List<GamesListDTO> findAll(){
		List<GamesListDTO> result = gameListServices.findAll();
		return result;
	}
	
}
