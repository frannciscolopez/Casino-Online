package com.casino.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "PLAYER")
public class Player implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long Id;
	
	private Long Balance;
	
	private Long UserProvider;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Long getBalance() {
		return Balance;
	}
	public void setBalance(Long balance) {
		Balance = balance;
	}
	public Long getUserProvider() {
		return UserProvider;
	}
	public void setUserProvider(Long userProvider) {
		UserProvider = userProvider;
	}
	
	

}
