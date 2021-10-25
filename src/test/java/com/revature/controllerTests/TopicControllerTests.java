package com.revature.controllerTests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controller.TopicController;
import com.revature.model.Topic;
import com.revature.service.TopicService;

@WebMvcTest(TopicController.class)
public class TopicControllerTests {
	
	static ObjectMapper objectMapper;
	
	@Autowired
	MockMvc mvc;
	static final String PATH = "/topics/";
	
	@MockBean
	TopicService service;
	
	Topic topic;
	String topicJson;
	
	@BeforeAll
	static void setup() {
		objectMapper = new ObjectMapper();
	}

	@BeforeEach
	void construct() throws JsonProcessingException {
		this.topic = new Topic(1, "Test Topic", "A Topic for testing.", null, null);
		this.topicJson = objectMapper.writeValueAsString(this.topic);
	}

	@Test
	public void getTopicById_returnsTopic() throws Exception {
		final int id = this.topic.getId();
		when(this.service.findById( id )).thenReturn(this.topic);
		
		this.mvc.perform(get( PATH + id ))
			.andExpect( status().isOk() )
			.andExpect( content().json(this.topicJson) );
	}

}
