package com.casino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casino.model.Play;



@Repository
public interface PlayRepository extends JpaRepository<Play,Long>{

}
