package com.casino.service;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casino.model.Player;
import com.casino.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Player> findAll() {
		return playerRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Player> findAll(Pageable pageable) {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Player> findById(Long id) {
		return playerRepository.findById(id);
	}

	@Override
	@Transactional
	public Player save(Player player) {
		return playerRepository.save(player);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		playerRepository.deleteById(id);
	}

	/**
	 * Este método resta al balance total de un jugador ''player'' el valor 
	 * de ''decrementValue''pasado por parámtero.
	 */
	public void decreaseBalance(Optional<Player> player, Long decrementValue) {
		Long actualBalance = player.get().getBalance();

		player.get().setBalance(actualBalance - decrementValue);
	}

	/**
	 * Este método suma al balance total de un jugador ''player'' el  valor 
	 * ''incrementValue'' pasado por parámetro.
	 */
	@Override
	public void increaseBalance(Optional<Player> player, Long incrementValue) {
		Long actualBalance = player.get().getBalance();

		player.get().setBalance(actualBalance + incrementValue);
	}

}
