package com.revature.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Technology;

@Repository
public interface TechnologyDao extends JpaRepository<Technology, Integer>{


	public Technology getByTechId(int id);
	
	public Optional<Technology> getByTechName(String name);

	
}