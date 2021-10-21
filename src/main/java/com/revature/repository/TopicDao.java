package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Topic;

@Repository
public interface TopicDao extends JpaRepository<Topic, Integer> {
	
	List<TopicDao> findByDate(int day);
	List<TopicDao> findByName(String name);
	List<TopicDao> findByTechnology(int id);

}
