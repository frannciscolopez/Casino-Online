package com.casino.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "PLAY")
public class Play implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long Id;
	
	private Long PlayerId;
	
	private Integer Increase;
	
	private String GameName;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getPlayerId() {
		return PlayerId;
	}

	public void setPlayerId(Long playerId) {
		PlayerId = playerId;
	}

	public Integer getIncrease() {
		return Increase;
	}

	public void setIncrease(Integer increase) {
		Increase = increase;
	}

	public String getGameName() {
		return GameName;
	}

	public void setGameName(String gameName) {
		GameName = gameName;
	}




	
	
	
	

}
