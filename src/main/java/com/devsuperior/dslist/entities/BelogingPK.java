package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class BelogingPK {

	@ManyToOne
	@JoinColumn(name = "game_id")
	private Games game;
	
	@ManyToOne
	@JoinColumn(name = "list_id")
	private GamesList list;
	
	public BelogingPK() {
	}

	public BelogingPK(Games game, GamesList list) {
		this.game = game;
		this.list = list;
	}

	public Games getGame() {
		return game;
	}

	public void setGame(Games game) {
		this.game = game;
	}

	public GamesList getList() {
		return list;
	}

	public void setList(GamesList list) {
		this.list = list;
	}

	@Override
	public int hashCode() {
		return Objects.hash(game, list);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelogingPK other = (BelogingPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(list, other.list);
	}
	
}
