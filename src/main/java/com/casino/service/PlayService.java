package com.casino.service;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.casino.model.Play;
import com.casino.model.Player;


public interface PlayService {
	
	public Iterable<Play> findAll();
	
	public Page<Play> findAll(Pageable pageable);
	
	public Optional<Play> findById(Long id);
	
	public Play save(Play play);
	
	public void deleteById(Long id);
	
	public Play registerPlay(Integer increase, Long playerId, String gameType);
	

}
