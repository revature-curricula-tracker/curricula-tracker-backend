package com.revature.controllerTests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controller.TopicController;
import com.revature.model.Topic;
import com.revature.service.TopicService;

@WebMvcTest(TopicController.class) 
class TopicControllerTests {
	
	static ObjectMapper objectMapper;
	
	@Autowired
	MockMvc mvc;
	static final String PATH = "/topics/";
	
	@MockBean
	TopicService service;
	
	Topic topic;
	String topicJson;
	
	List<Topic> topicList;
	String listJson;
	
	@BeforeAll
	static void setup() {
		objectMapper = new ObjectMapper();
	}

	@BeforeEach
	void construct() throws JsonProcessingException {
		this.topic = new Topic(1, 1, "Test Topic", "A Topic for testing.", null, null);
		this.topicJson = objectMapper.writeValueAsString(this.topic);
		
		this.topicList = new LinkedList<Topic>();
		this.topicList.add(this.topic);
		this.listJson = objectMapper.writeValueAsString(this.topicList);
	}

	@Test
	void findAll_returnsList() throws Exception {
		when(this.service.findAll()).thenReturn(this.topicList);
		
		this.mvc.perform(get( PATH ))
			.andExpect( status().isOk() )
			.andExpect( content().json(this.listJson) );
	}

	@Test
	void getTopicById_returnsTopic() throws Exception {
		when(this.service.findById( this.topic.getId() )).thenReturn(this.topic);
		
		this.mvc.perform(get( PATH + this.topic.getId() ))
			.andExpect( status().isOk() )
			.andExpect( content().json(this.topicJson) );
	}

	@Test
	void getTopicByName_returnsTopic() throws Exception {
		when(this.service.findByName( this.topic.getName() )).thenReturn(this.topicList);
		
		this.mvc.perform(get( PATH + "search/" + this.topic.getName()))
			.andExpect( status().isOk() )
			.andExpect( content().json(this.listJson) );
	}
	
	@Test
	void addTopic_returnsTopic() throws Exception {
		when(this.service.save(this.topic)).thenReturn(this.topic);
		
		this.mvc.perform(post( PATH + "add" )
			.content(this.topicJson)
			.contentType(MediaType.APPLICATION_JSON) )
			.andExpect( status().isOk() )
			.andExpect( content().json(this.topicJson) );
	}

	@Test
	void updateTopic_returnsTopic() throws Exception {
		when(this.service.update(this.topic)).thenReturn(this.topic);
		
		this.mvc.perform(put( PATH + this.topic.getId())
			.content(this.topicJson)
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect( status().isOk() )
			.andExpect( content().json(this.topicJson) );
	}
	
	@Test
	void deleteTopic_success() throws Exception {
		this.mvc.perform(delete( PATH + this.topic.getId() ))
			.andExpect( status().isOk() );
	}
	
}
