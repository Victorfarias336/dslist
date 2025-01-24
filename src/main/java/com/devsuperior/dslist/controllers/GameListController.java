package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GamesListDTO;
import com.devsuperior.dslist.dto.GamesMinDTO;
import com.devsuperior.dslist.dto.replacementDTO;
import com.devsuperior.dslist.services.GameListServices;
import com.devsuperior.dslist.services.GameServices;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	@Autowired
	private GameListServices gameListServices;
	
	@Autowired
	private GameServices gameServices;
	
	@GetMapping
	public List<GamesListDTO> findAll(){
		List<GamesListDTO> result = gameListServices.findAll();
		return result;
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GamesMinDTO> findByList(@PathVariable Long listId){
		List<GamesMinDTO> result = gameServices.findByList(listId);
		return result;
	}
	
	@PostMapping(value = "/{listId}/replacement")
	public void move(@PathVariable Long listId, @RequestBody replacementDTO body){
		gameListServices.move(listId, body.getSourceIndex(), body.getDestinationIndex());
		
	}
	
}
