package com.revature.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Curriculum;
import com.revature.model.CurriculumTopic;
import com.revature.model.Topic;

@Repository
public interface CurriculumTopicDao extends JpaRepository<CurriculumTopic, Integer> {

}
