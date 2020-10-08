package com.casino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casino.model.Player;



@Repository
public interface PlayerRepository extends JpaRepository<Player,Long>{

}
