package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.GameRepositories.GameListRepository;
import com.devsuperior.dslist.dto.GamesListDTO;

@Service
public class GameListServices {

	@Autowired
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GamesListDTO> findAll(){
//		List<GamesList> result ou
		var result = gameListRepository.findAll();
		List<GamesListDTO> dto = result.stream().map(x -> new GamesListDTO(x)).toList();
		return dto;		
	}

}
