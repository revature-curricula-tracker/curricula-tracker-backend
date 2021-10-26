package com.revature.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Topic;
import com.revature.service.TopicService;

@RestController
@RequestMapping("/topics")
@CrossOrigin(origins = "http://localhost:4200")
public class TopicController {

	@Autowired
	TopicService topicService;

	@GetMapping
	/*
	 * controller that calls the findAll method
	 * @return = list containing all Topics in the repository
	 */
	public List<Topic> findAll() {
		return topicService.findAll();
	}

	@GetMapping("/{id}")
	/*
	 * controller that calls the findById method
	 * @param id = unique integer representing Topic searched for
	 * @return = Topic from Repository with id == id
	 */
	public Topic getTopicById(@PathVariable("id") final int id) {
		return topicService.findById(id);
	}

	@GetMapping("/search/{name}")
	/*
	 * controller that calls the findByName method
	 * @param name = name of Topic being searched for
	 * @return = Topic from repository with name == name
	 */
	public List<Topic> getTopicByName(@PathVariable("name") final String name) {
		return topicService.findByName(name);
	}

	@PostMapping("/add")
	/*
	 * controller that calls the save method
	 * @param t = Topic being added to repository
	 * @return = Topic added to repository
	 */
	public Topic addTopic(@Valid @RequestBody final Topic t) {
		return topicService.save(t);
	}

	@PutMapping("/{id}")
	/*
	 * controller that calls the update method
	 * @param t = Topic being updated in repository
	 * @return = updated Topic from repository
	 */
	public Topic updateTopic(@Valid @RequestBody final Topic t) {
		return topicService.update(t);
	}

	@DeleteMapping("/{id}")
	/*
	 * controller that calls the delete method
	 * @param id = unique integer signifying Topic to be deleted
	 */
	public void delete(@PathVariable final int id) {
		topicService.delete(id);
	}

}
