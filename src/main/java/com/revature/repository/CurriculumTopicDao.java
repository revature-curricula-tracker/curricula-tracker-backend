package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.CurriculumTopic;
import com.revature.model.CurriculumTopicKey;

@Repository
public interface CurriculumTopicDao extends JpaRepository<CurriculumTopic, Integer> {
	
//	public void CurriculumTopicDelete(CurriculumTopicKey ctk);
}
