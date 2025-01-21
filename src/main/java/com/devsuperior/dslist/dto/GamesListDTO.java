package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.GamesList;

public class GamesListDTO {

	private Long id;
	private String name;
	
	public GamesListDTO() {
	}
	
	public GamesListDTO(GamesList Entity) {
		this.id = Entity.getId();
		this.name = Entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
}
