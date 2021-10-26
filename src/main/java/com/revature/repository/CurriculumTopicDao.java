package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.CurriculumTopic;
import com.revature.model.CurriculumTopicKey;

@Repository
public interface CurriculumTopicDao extends JpaRepository<CurriculumTopic, Integer> {

	CurriculumTopic findByCurriculumTopicKey(CurriculumTopicKey id);
	
	 @Transactional
	 @Modifying
     @Query("DELETE FROM CurriculumTopic WHERE curriculum_id =:#{#id}") // 
     void deleteByCuriculumId(@Param("id")int CurriculumId);
	
}
