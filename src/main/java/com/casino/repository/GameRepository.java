package com.casino.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casino.model.Game;



@Repository
public interface GameRepository extends JpaRepository<Game,Long>{
	
	Optional<Game> findByGameType (String GameType);

}
