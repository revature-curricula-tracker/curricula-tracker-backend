package com.revature.controllerTests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.revature.controller.TechnologyController;
import com.revature.model.Technology;
import com.revature.model.Topic;
import com.revature.service.TechnologyService;

@WebMvcTest(TechnologyController.class)
public class TechnologyControllerTests {
	
	static ObjectMapper objectMapper;

	@Autowired
	private MockMvc mvc;
	static final String PATH = "/tech/";

	@MockBean
	private TechnologyService techserv;

	Technology tech;
	Optional<Technology> techopt;
	String techJson;
	String techoptJson;

	@BeforeAll
	static void setup() {
		objectMapper = new ObjectMapper();
	}
	
	@BeforeEach
	void construct() throws JsonProcessingException {
		this.tech =  new Technology(1, "testy", new ArrayList<Topic>(), "red");
		this.techJson = objectMapper.writeValueAsString(this.tech);
		this.techopt = Optional.of(new Technology(2, "java", new ArrayList<Topic>(), "blue"));
		this.techoptJson = objectMapper.writeValueAsString(this.techopt.get());
	}

	@Test
	void testGetById() throws Exception {
		final int id = this.techopt.get().getTechId();
		
		when(this.techserv.getById( id )).thenReturn(this.techopt);
		
		this.mvc.perform(get( PATH + id ))
			.andExpect( status().isOk() )
			.andExpect( content().json(this.techoptJson) );
	}
	
	@Test
	void getByName_returnsTech() throws Exception {
		final String name = this.techopt.get().getTechName();
		when(this.techserv.getByName( name )).thenReturn(this.techopt);
		
		this.mvc.perform(get( PATH + "search/" + name))
			.andExpect( status().isOk() )
			.andExpect( content().json(this.techoptJson) );
	}
	
	@Test
	void TestFindAllTechnologies() throws Exception {
		List<Technology> techs = new ArrayList<>();
		techs.add(tech);
		when(this.techserv.findAll()).thenReturn(techs);
		
		this.mvc.perform(get( PATH ))
			.andExpect( status().isOk() );
	}
	
	@Test
	void addTech_returnsTech() throws Exception {
		when(this.techserv.insertTechnology(this.tech)).thenReturn(this.tech);
		
		this.mvc.perform(post( PATH + "add" ).content(this.techJson).contentType(MediaType.APPLICATION_JSON) )
			.andExpect( status().isOk() )
			.andExpect( content().json(this.techJson) );
	}
	
	@Test
	void updateTech_returnsTech() throws Exception {
		final int id = this.tech.getTechId();
		when(this.techserv.update(this.tech)).thenReturn(this.tech);
		
		this.mvc.perform(patch( PATH + id ).content(this.techJson).contentType(MediaType.APPLICATION_JSON) )
			.andExpect( status().isOk() )
			.andExpect( content().json(this.techJson) );
	}
	
	@Test
	void deleteTech_returnsTrue() throws Exception {
		final int id = this.tech.getTechId();
		when(this.techserv.deleteTechnology(id)).thenReturn(true);
		
		this.mvc.perform(delete( PATH + id ))
			.andExpect( status().isOk() )
			.andExpect( content().string("true"));
	}
}
