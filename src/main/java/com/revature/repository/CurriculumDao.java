package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Curriculum;

@Repository
public interface CurriculumDao extends JpaRepository<Curriculum, Integer>{

}
