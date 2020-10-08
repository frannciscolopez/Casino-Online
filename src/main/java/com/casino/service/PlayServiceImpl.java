package com.casino.service;

import java.awt.print.Pageable;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casino.model.Play;
import com.casino.repository.PlayRepository;

@Service
public class PlayServiceImpl implements PlayService {

	@Autowired
	private PlayRepository playRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Play> findAll() {
		return playRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Play> findAll(Pageable pageable) {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Play> findById(Long id) {
		return playRepository.findById(id);
	}

	@Override
	@Transactional
	public Play save(Play play) {
		return playRepository.save(play);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		 playRepository.deleteById(id);
		
	}

	/**
	 * Este método registra una jugada a partir de los parámetros
	 * ''increase'', ''playerId'' y ''gameType''.
	 */
	@Override
	public Play registerPlay(Integer increase, Long playerId, String gameType) {
	Play play = new Play();
	
	play.setIncrease(increase);
	play.setPlayerId(playerId);
	play.setGameName(gameType);
	
	return save(play);
	}

}
