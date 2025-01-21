package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Games;
import com.devsuperior.dslist.projections.GameMinProjection;

public class GamesMinDTO {
	
	private Long id;
	private String titulo;
	private Integer ano;
	private String imgUrl;
	private String shortDescription;
	
	public GamesMinDTO() {
	}

	public GamesMinDTO(Games entity) {
		this.id = entity.getId();
		this.titulo = entity.getTitulo();
		this.ano = entity.getAno();
		this.imgUrl = entity.getImgUrl();
		this.shortDescription = entity.getShortDescription();
	}
	
	public GamesMinDTO(GameMinProjection projection) {
		this.id = projection.getId();
		this.titulo = projection.getTitulo();
		this.ano = projection.getAno();
		this.imgUrl = projection.getImgUrl();
		this.shortDescription = projection.getShortDescription();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public Integer getAno() {
		return ano;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

}
