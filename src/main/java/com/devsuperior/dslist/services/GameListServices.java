package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.GameRepositories.GameListRepository;
import com.devsuperior.dslist.GameRepositories.GameRepository;
import com.devsuperior.dslist.dto.GamesListDTO;
import com.devsuperior.dslist.projections.GameMinProjection;

@Service
public class GameListServices {

	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GamesListDTO> findAll(){
//		List<GamesList> result ou
		var result = gameListRepository.findAll();
		List<GamesListDTO> dto = result.stream().map(x -> new GamesListDTO(x)).toList();
		return dto;		
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), null);
		}
		
	}

}
