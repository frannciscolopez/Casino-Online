package com.casino.service;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.casino.model.Game;



public interface GameService {
	
	public Iterable<Game> findAll();
	
	public Page<Game> findAll(Pageable pageable);
	
	public Optional<Game> findById(Long id);
	
	public Optional<Game> findByGameType(String GameType);
	
	public Game save(Game game);
	
	public void deleteById(Long id);
	
	public String winOrLose(Integer PrizeProbability);
	
	public void gameTime(Optional<Game> game);
	
	public boolean isWinningPlay(Optional<Game> game);
	

}
