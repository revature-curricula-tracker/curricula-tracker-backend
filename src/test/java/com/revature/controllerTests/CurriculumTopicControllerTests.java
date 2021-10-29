package com.revature.controllerTests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
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
import com.revature.controller.CurriculumTopicController;
import com.revature.model.Curriculum;
import com.revature.model.CurriculumTopic;
import com.revature.model.CurriculumTopicKey;
import com.revature.model.Topic;
import com.revature.service.CurriculumTopicService;

@WebMvcTest(CurriculumTopicController.class)
class CurriculumTopicControllerTests {
	
	static ObjectMapper objectMapper;

	@Autowired
	private MockMvc mvc;
	static final String PATH = "/curriculumTopic/";

	@MockBean
	private CurriculumTopicService ctserv;

	CurriculumTopic ct;
	CurriculumTopicKey id;
	String ctJson;
	
	@BeforeAll
	static void setup() {
		objectMapper = new ObjectMapper();
	}
	
	@BeforeEach
	void construct() throws JsonProcessingException {
		this.id = new CurriculumTopicKey();
		id.setCurriculumId(1);
		id.setTopicId(1);
		this.ct = new CurriculumTopic(id, new Curriculum(), new Topic(), 1);
		this.ctJson = objectMapper.writeValueAsString(this.ct);
		
	}
	
	@Test
	void insert_returnsCt() throws Exception {
		when(this.ctserv.insert(this.ct)).thenReturn(this.ct);
		
		this.mvc.perform(post( PATH + "add" ).content(this.ctJson).contentType(MediaType.APPLICATION_JSON) )
			.andExpect( status().isOk() )
			.andExpect( content().json(this.ctJson) );
	}
	
	@Test
	void TestFindAllCurriculumTopics() throws Exception {
		List<CurriculumTopic> cts = new ArrayList<>();
		cts.add(ct);
		when(this.ctserv.findAll()).thenReturn(cts);
		String ctsJson = objectMapper.writeValueAsString(cts);
		
		this.mvc.perform(get( PATH ).content(ctsJson).contentType(MediaType.APPLICATION_JSON) )
			.andExpect( status().isOk() )
			.andExpect( content().json(ctsJson) );
	}
	
	@Test
	void testGetByIds() throws Exception {
		when(this.ctserv.findByIds(1, 1)).thenReturn(this.ct);
		
		this.mvc.perform(get( PATH + "findByIds/1&1" ).content(this.ctJson).contentType(MediaType.APPLICATION_JSON) )
			.andExpect( status().isOk() )
			.andExpect( content().json(this.ctJson) );
	}
	
	@Test
	void testDelete_returnsTrue() throws Exception {
		when(this.ctserv.findByIds(1, 1)).thenReturn(this.ct);
		when(this.ctserv.removeByIds(1, 1)).thenReturn(true);
		
		this.mvc.perform(delete( PATH + "deleteByIds/1&1" ).content(this.ctJson).contentType(MediaType.APPLICATION_JSON) )
			.andExpect( status().isOk() )
			.andExpect( content().string("true") );
	}
	
	
	
	
	
	
	
	

}
