package com.revature.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class TopicController {

	@Autowired
	TopicService topicService;
	
	@GetMapping
	public ResponseEntity<List<Topic>> findAll() {
		return ResponseEntity.ok(topicService.findAll());
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<Topic> getTopicById(@PathVariable("id") final int id) {
		return ResponseEntity.ok(topicService.findById(id));
	}
	
	@GetMapping("/search/{name}") 
	public ResponseEntity<List<Topic>> getTopicByName(@PathVariable("name") final String name) {
		return ResponseEntity.ok(topicService.findByName(name));
	}
	
	@PostMapping("/add")			
	public ResponseEntity<Topic> addTopic(@Valid @RequestBody final Topic t) {
		return ResponseEntity.ok(topicService.save(t));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Topic> updateTopic(@Valid @RequestBody final Topic t) {
		return ResponseEntity.ok(topicService.update(t));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable final int id) {
		topicService.delete(id);
    }
	
}
