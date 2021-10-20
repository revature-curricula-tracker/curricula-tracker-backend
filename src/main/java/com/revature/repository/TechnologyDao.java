package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Technology;

public interface TechnologyDao extends JpaRepository<Technology, Integer>{

}