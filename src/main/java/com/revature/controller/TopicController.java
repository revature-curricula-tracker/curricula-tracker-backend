package com.revature.controller;

import java.util.LinkedList;
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

import com.revature.advice.CorsFilter;
import com.revature.model.Topic;
import com.revature.model.json.SendTopicJson;
import com.revature.service.TopicService;

@RestController
@RequestMapping("/topics")
@CrossOrigin(origins = CorsFilter.ORIGIN)
public class TopicController {

	@Autowired
	TopicService topicService;

	@GetMapping
	public List<SendTopicJson> findAll() {
		final List<SendTopicJson> list = new LinkedList<>();
		for(final Topic topic: this.topicService.findAll())
			list.add(new SendTopicJson(topic));
		return list;
	}

	@GetMapping("/{id}")
	public SendTopicJson getTopicById(@PathVariable("id") final int id) {
		final Topic topic = this.topicService.findById(id);
		return topic == null ? null : new SendTopicJson( topic );
	}

	@GetMapping("/search/{name}")
	public List<SendTopicJson> getTopicByName(@PathVariable("name") final String name) {
		final List<SendTopicJson> list = new LinkedList<>();
		for(final Topic topic: this.topicService.findByName(name))
			list.add(new SendTopicJson(topic));
		return list;
	}

	@PostMapping("/add")
	public SendTopicJson addTopic(@Valid @RequestBody final Topic t) {
		final Topic topic = this.topicService.save(t);
		return topic == null ? null : new SendTopicJson( topic );
	}

	@PutMapping("/{id}")
	public SendTopicJson updateTopic(@Valid @RequestBody final Topic t) {
		final Topic topic = this.topicService.update(t);
		return topic == null ? null : new SendTopicJson( topic );
	}

	@PutMapping("/byname/{name}")
	public List<SendTopicJson> updateTopicsByName(@PathVariable final String name, @Valid @RequestBody final Topic t) {
		final List<SendTopicJson> list = new LinkedList<>();
		for(final Topic topic: this.topicService.updateByName( name.replace('_', ' '), t ))
			list.add(new SendTopicJson(topic));
		return list;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable final int id) {
		this.topicService.delete(id);
	}

	@DeleteMapping("/byname/{name}")
	public void deleteTopicsByName(@PathVariable final String name) {
		this.topicService.deleteByName(name.replace('_',' '));
	}

}
