package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.Topic;

@Repository
public interface TopicDao extends JpaRepository<Topic, Integer> {
	
	List<Topic> findByName(String name);
	
	void deleteByName(String name);
	
	@Modifying
	@Query("UPDATE com.revature.model.Topic SET name = ?2, description = ?3 WHERE name = ?1")
	void updateByName(String curName, String newName, String desc);
	
}