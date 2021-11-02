package com.revature.controller;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.revature.model.json.TopicJson;
import com.revature.service.TopicService;

@RestController
@RequestMapping("/topics")
@CrossOrigin(origins = {CorsFilter.ORIGIN,CorsFilter.LOCALHOST,CorsFilter.ORIGIN_NEW})
public class TopicController {
	
	private static final Logger logger = LoggerFactory.getLogger(TopicController.class);

	@Autowired
	TopicService topicService;

	@GetMapping
	public List<TopicJson> findAll() {
		logger.info("findAll(Topic) method started");
		final List<TopicJson> list = new LinkedList<>();
		for(final Topic topic: this.topicService.findAll())
			list.add(new TopicJson(topic));
		logger.info("findAll(Topic) method ended");
		return list;
	}

	@GetMapping("/{id}")
	public TopicJson getTopicById(@PathVariable("id") final int id) {
		logger.info("getTopicById() method started");
		final Topic topic = this.topicService.findById(id);
		logger.info("getTopicById() method ended");
		return topic == null ? null : new TopicJson( topic );
	}

	@GetMapping("/search/{name}")
	public List<TopicJson> getTopicByName(@PathVariable("name") final String name) {
		logger.info("getTopicByName() method started");
		final List<TopicJson> list = new LinkedList<>();
		for(final Topic topic: this.topicService.findByName(name))
			list.add(new TopicJson(topic));
		logger.info("getTopicByName() method ended");
		return list;
	}

	@PostMapping("/add")
	public TopicJson addTopic(@Valid @RequestBody final TopicJson topicJson) {
		logger.info("addTopic() method started");
		final Topic topic = this.topicService.save(topicJson.constructTopic());
		logger.info("addTopic() method ended");
		return topic == null ? null : new TopicJson( topic );
	}

	@PutMapping("/{id}")
	public TopicJson updateTopic(@Valid @RequestBody final TopicJson topicJson) {
		logger.info("updateTopic() method started");
		final Topic topic = this.topicService.update(topicJson.constructTopic());
		logger.info("updateTopic() method ended");
		return topic == null ? null : new TopicJson( topic );
	}

	@PutMapping("/byname/{name}")
	public List<TopicJson> updateTopicsByName(@PathVariable final String name, @Valid @RequestBody final Topic t) {
		logger.info("updateTopicsByName() method started");
		final List<TopicJson> list = new LinkedList<>();
		for(final Topic topic: this.topicService.updateByName( name.replace('_', ' '), t ))
			list.add(new TopicJson(topic));
		logger.info("updateTopicsByName() method ended");
		return list;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable final int id) {
		logger.info("delete(Topic) method started");
		this.topicService.delete(id);
	}

	@DeleteMapping("/byname/{name}")
	public void deleteTopicsByName(@PathVariable final String name) {
		logger.info("deleteTopicsByName() method started");
		this.topicService.deleteByName(name.replace('_',' '));
	}

}
