package com.revature.controllerTests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controller.CurriculumController;
import com.revature.model.Curriculum;
import com.revature.model.json.CurriculumJson;
import com.revature.service.CurriculumService;


@WebMvcTest(CurriculumController.class)
class CurriculumControllerTests {
	
	static ObjectMapper objectMapper;
	
	@Autowired
	MockMvc mvc;
	static final String PATH = "/curriculum/";
	
	@MockBean
	CurriculumService service;
	
	Curriculum curriculum;
	CurriculumJson curriculumJsonObject;
	String curriculumJson;
	
	@BeforeAll
	static void setup() {
		objectMapper = new ObjectMapper();
	}

	@BeforeEach
	void construct() throws JsonProcessingException {
		this.curriculum = new Curriculum(2, new HashSet<>(), "JavaScript: Fun Times", 5, 25);
		this.curriculumJsonObject = new CurriculumJson(this.curriculum);
		this.curriculumJson = objectMapper.writeValueAsString( this.curriculumJsonObject);
	}

	@Test
	void getcurriculumById_returnscurriculum() throws Exception {
		final int id = this.curriculum.getCurriculumId();
		when(this.service.getById( id )).thenReturn(this.curriculum);
		
		this.mvc.perform(get( PATH +"/findId/"+ id ))
			.andExpect( status().isOk() )
			.andExpect( content().json(this.curriculumJson) );
	}
	@Test
	void getcurriculumByName_returnscurriculum() throws Exception {
		final String name = this.curriculum.getCurriculumName();
		when(this.service.getByCurriculumName( name )).thenReturn(this.curriculum);
		
		this.mvc.perform(get( PATH +"/findName/"+ name ))
			.andExpect( status().isOk() )
			.andExpect( content().json(this.curriculumJson) );
	}
	@Test
	void TestFindAllCurriculum() throws Exception {
		final List<Curriculum> curricula = new ArrayList<>();
		curricula.add(curriculum);
		when(this.service.findAll()).thenReturn(curricula);
		
		this.mvc.perform(get( PATH))
			.andExpect( status().isOk() );
	}
	@Test
	void removecurriculumById_returnsnothing() throws Exception {
		final int id = 1;
		
		this.mvc.perform(delete( PATH +"/deleteById/"+ id ))
			.andExpect( status().isOk() );
	}

	/*
	@Test
	void addcurriculum_returnscurriculum() throws Exception {
		when(this.service.insert(this.curriculum)).thenReturn(this.curriculum);
		
		this.mvc.perform(post( PATH + "add" ).content(this.curriculumJson).contentType(MediaType.APPLICATION_JSON) )
			.andExpect( status().isOk() )
			.andExpect( content().json(this.curriculumJson) );
	}
	
	@Test
	void updatecurriculum_returnscurriculum() throws Exception {
		when(this.service.update(this.curriculum)).thenReturn(this.curriculum);
		
		this.mvc.perform(post( PATH + "update").content(this.curriculumJson).contentType(MediaType.APPLICATION_JSON))
			.andExpect( status().isOk() )
			.andExpect( content().json(this.curriculumJson) );
	}*/
}
