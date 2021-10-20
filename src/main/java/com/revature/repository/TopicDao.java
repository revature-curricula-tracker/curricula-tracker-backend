package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Topic;

public interface TopicDao extends JpaRepository<Topic, Integer>{

}
