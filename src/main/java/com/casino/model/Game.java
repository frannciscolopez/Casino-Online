package com.casino.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "GAME")
public class Game implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String gameType;
	
	private Integer MinimumBet;
	
	private Integer MaximumBet;
	
	private Integer PrizeProbability;
	
	private float GameTime;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		gameType = gameType;
	}

	public Integer getMinimumBet() {
		return MinimumBet;
	}

	public void setMinimumBet(Integer minimumBet) {
		MinimumBet = minimumBet;
	}

	public Integer getMaximumBet() {
		return MaximumBet;
	}

	public void setMaximumBet(Integer maximumBet) {
		MaximumBet = maximumBet;
	}

	public Integer getPrizeProbability() {
		return PrizeProbability;
	}

	public void setPrizeProbability(Integer prizeProbability) {
		PrizeProbability = prizeProbability;
	}

	public float getGameTime() {
		return GameTime;
	}

	public void setGameTime(float gameTime) {
		GameTime = gameTime;
	}

	
	
	
	

}
