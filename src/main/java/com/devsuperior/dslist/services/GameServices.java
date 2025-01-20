package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.GameRepositories.GameRepository;
import com.devsuperior.dslist.dto.GamesMinDTO;

@Service
public class GameServices {

	@Autowired
	private GameRepository gameRepository;
	
	public List<GamesMinDTO> findAll(){
//		List<Game> result ou
		var result = gameRepository.findAll();
		List<GamesMinDTO> dto = result.stream().map(x -> new GamesMinDTO(x)).toList();
		return dto;		
	}

}
