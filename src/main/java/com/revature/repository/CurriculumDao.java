package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Curriculum;

public interface CurriculumDao  extends JpaRepository<Curriculum, Integer>{

}
