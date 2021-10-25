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
	private TopicDao topicDao;
	
	@Transactional(readOnly=true)
	public List<Topic> findAll() {
		return this.topicDao.findAll();
	}
	
	@Transactional(readOnly=true)
	public Topic findById(final int id) {
		final Optional<Topic> topic = this.topicDao.findById(id);
		return topic.isPresent() ? topic.get() : null;
	}

	@Transactional(readOnly=true)
	public List<Topic> findByName(final String name) {
		return this.topicDao.findByName(name);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Topic save(final Topic topic) {
		return this.topicDao.save(topic);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Topic update(final Topic topic) {
		return this.topicDao.save(topic);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void delete(final Topic topic) {
		this.topicDao.delete(topic);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void delete(final int id) {
		this.topicDao.deleteById(id);
	}
	
}
