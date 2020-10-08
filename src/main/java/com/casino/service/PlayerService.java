package com.casino.service;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.casino.model.Player;


public interface PlayerService {
	
	public Iterable<Player> findAll();
	
	public Page<Player> findAll(Pageable pageable);
	
	public Optional<Player> findById(Long id);
	
	public Player save(Player player);
	
	public void deleteById(Long id);
	
	public void decreaseBalance(Optional<Player> player, Long decrementValue);
	
	public void increaseBalance(Optional<Player> player, Long incrementValue);
	
	

}
