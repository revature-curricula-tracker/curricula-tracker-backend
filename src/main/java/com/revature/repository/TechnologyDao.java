package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.model.Technology;

@Repository
public interface TechnologyDao extends JpaRepository<Technology, Integer>{
}
