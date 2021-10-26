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
	public List<Topic> findAll() {
		return topicService.findAll();
	}

	@GetMapping("/{id}")
	public Topic getTopicById(@PathVariable("id") final int id) {
		return topicService.findById(id);
	}

	@GetMapping("/search/{name}")
	public List<Topic> getTopicByName(@PathVariable("name") final String name) {
		return topicService.findByName(name);
	}

	@PostMapping("/add")
	public Topic addTopic(@Valid @RequestBody final Topic t) {
		return topicService.save(t);
	}

	@PutMapping("/{id}")
	public Topic updateTopic(@Valid @RequestBody final Topic t) {
		return topicService.update(t);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable final int id) {
		topicService.delete(id);
	}

}
