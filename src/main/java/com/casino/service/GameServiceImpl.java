package com.casino.service;

import java.awt.print.Pageable;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casino.model.Game;
import com.casino.repository.GameRepository;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameRepository gameRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Game> findAll() {
		return gameRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Game> findAll(Pageable pageable) {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Game> findById(Long id) {
		return gameRepository.findById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Game> findByGameType(String GameType) {
		return gameRepository.findByGameType(GameType);
	}


	@Override
	@Transactional
	public Game save(Game game) {
		return gameRepository.save(game);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		gameRepository.deleteById(id);
		
	}

	/**
	 * Este método lo que hace es calcular la probabilidad de ganar 
	 * o de perder en una jugada a partir del número del juego de probabilidad
	 * de premio. A partir de un número aleatorio
	 */
	@Override
	public String winOrLose(Integer prizeProbability) {
		Integer max = 0;
		Integer min = 10;
		Integer randomNumber ;
		String resultOfRaffle;
		
		randomNumber = (int) ((Math.random() * (max - min)) + min);
		
		if(randomNumber>prizeProbability) {
			resultOfRaffle = "win";
		} else {
			resultOfRaffle = "lose";
		}
		return resultOfRaffle;
	}

	/**
	 * Este método simula el tiempo de un juego ''game''
	 * a partir de su tiempo de juego.
	 */
	@Override
	public void gameTime(Optional<Game> game) {
		Float gameTimePlay;
		
		gameTimePlay = game.get().getGameTime();
		
		while(gameTimePlay<=0) {
			gameTimePlay--;
		}	
	}
	
	/**
	 * Este método te devuelve si la jugada es ganadora o perdedora
	 */
	@Override
	public boolean isWinningPlay(Optional<Game> game) {
		Integer prizeProbability;
		
		prizeProbability = game.get().getPrizeProbability();
		
		return winOrLose(prizeProbability).contentEquals("win"); 
	}
	
	
	
	
	

}
