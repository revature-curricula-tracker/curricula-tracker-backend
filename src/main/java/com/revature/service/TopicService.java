package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Topic;
import com.revature.repository.TopicDao;

@Service
public class TopicService {

	@Autowired
	//TopicDao that can call methods directly accessing the repository
	private TopicDao topicDao;
	
	@Transactional(readOnly=true)
	//returns all Topics
	public List<Topic> findAll() {
		return this.topicDao.findAll();
	}
	
	@Transactional(readOnly=true)
	//returns Topic with the input id
	public Topic findById(final int id) {
		final Optional<Topic> topic = this.topicDao.findById(id);
		return topic.isPresent() ? topic.get() : null;
	}

	@Transactional(readOnly=true)
	//returns Topic with input name
	public List<Topic> findByName(final String name) {
		return this.topicDao.findByName(name);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	//inserts input Topic to repository
	public Topic save(final Topic topic) {
		return this.topicDao.save(topic);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	//updates the input Topic in the repository
	public Topic update(final Topic topic) {
		return this.topicDao.save(topic);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	//removes Topic with input name from repository
	public void delete(final Topic topic) {
		this.topicDao.delete(topic);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	//removes Topic with input id from repository
	public void delete(final int id) {
		this.topicDao.deleteById(id);
	}
	
}
