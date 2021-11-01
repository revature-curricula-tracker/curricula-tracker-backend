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
	
	/**
	 * Returns a list of all Topics stored in the database.
	 * @return 		a list of all Topics
	 */
	@Transactional(readOnly=true)
	public List<Topic> findAll() {
		return this.topicDao.findAll();
	}
	
	/**
	 * Returns a Topic object if one exists with the specified id, otherwise returns null.
	 * @param 	id	the id of the Topic
	 * @return 		a list of all Topics
	 */
	@Transactional(readOnly=true)
	public Topic findById(final int id) {
		final Optional<Topic> topic = this.topicDao.findById(id);
		return topic.isPresent() ? topic.get() : null;
	}

	/**
	 * Returns a list of Topics that have the specified name.
	 * @param 	name	the name of the Topic
	 * @return 			a list of all Topics with specified name
	 */
	@Transactional(readOnly=true)
	public List<Topic> findByName(final String name) {
		return this.topicDao.findByName(name);
	}
	
	/**
	 * Saves a new Topic object in the database, and then returns the saved Topic.
	 * @param 	topic	the Topic object to be saved
	 * @return 			the Topic object that was saved
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Topic save(final Topic topic) {
		return this.topicDao.save(topic);
	}
	
	/**
	 * Updates a Topic object in the database, and then returns the updated Topic.
	 * @param 	topic	the Topic object to be updated
	 * @return 			the Topic object that was updated
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<Topic> updateByName(final String name, final Topic topic) {
		this.topicDao.updateByName(name, topic.getName(), topic.getDescription());
		return this.topicDao.findByName(name);
	}
	
	/**
	 * Updates a Topic object in the database, and then returns the updated Topic.
	 * @param 	topic	the Topic object to be updated
	 * @return 			the Topic object that was updated
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Topic update(final Topic topic) {
		return this.topicDao.save(topic);
	}
	
	/**
	 * Deletes a specified Topic object in the database if it exists.
	 * @param 	topic	the Topic object to be deleted
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void delete(final Topic topic) {
		this.topicDao.delete(topic);
	}
	
	/**
	 * Deletes a Topic object with specified id in the database if it exists.
	 * @param 	id	the id of the Topic object to be deleted
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void delete(final int id) {
		this.topicDao.deleteById(id);
	}
	
	/**
	 * Deletes a Topic object with specified id in the database if it exists.
	 * @param 	id	the id of the Topic object to be deleted
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteByName(final String name) {
		this.topicDao.deleteByName(name);
	}
	
}
