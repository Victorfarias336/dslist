package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.GameRepositories.GameRepository;
import com.devsuperior.dslist.dto.GamesDTO;
import com.devsuperior.dslist.dto.GamesMinDTO;
import com.devsuperior.dslist.entities.Games;
import com.devsuperior.dslist.projections.GameMinProjection;

@Service
public class GameServices {

	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GamesMinDTO> findAll(){
//		List<Game> result ou
		var result = gameRepository.findAll();
		List<GamesMinDTO> dto = result.stream().map(x -> new GamesMinDTO(x)).toList();
		return dto;		
	}
	
	@Transactional(readOnly = true)
	public List<GamesMinDTO> findByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		List<GamesMinDTO> dto = result.stream().map(x -> new GamesMinDTO(x)).toList();
		return dto;		
	}
	
	@Transactional(readOnly = true)
	public GamesDTO findById(Long id) {
		Games result = gameRepository.findById(id).get();
		GamesDTO dto = new GamesDTO(result);
		return dto;
	}

}
