package com.revature.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<Topic> getTopicById(@PathVariable("id") int id) {
		return ResponseEntity.ok(topicService.findById(id));
	}
	
	@GetMapping("/search") 
	public ResponseEntity<List<Topic>> getTopicByName(@RequestParam("name") String name) {
		return ResponseEntity.ok(topicService.findByName(name));
	}
	
	@PostMapping("/add")			
	public ResponseEntity<Topic> addUser(@Valid @RequestBody Topic t) {
		return ResponseEntity.ok(topicService.save(t));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		topicService.delete(id);
    }
	
}
