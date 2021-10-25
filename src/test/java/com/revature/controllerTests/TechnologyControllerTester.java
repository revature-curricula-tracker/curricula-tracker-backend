package com.revature.controllerTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.controller.TechnologyController;
import com.revature.model.Technology;
import com.revature.model.Topic;
import com.revature.repository.TechnologyDao;
import com.revature.service.TechnologyService;

@WebMvcTest(TechnologyController.class)
public class TechnologyControllerTester {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private TechnologyService techServ;
	
	private Technology tech;

	@BeforeEach
	void setup()
	{
		tech = new Technology(1, "testy", new ArrayList<Topic>());
	}
	
	@Test
	void testGetById() throws Exception
	{
		given(techServ.getById(1)).willReturn(Optional.of(tech));
		given(techServ.getById(72)).willReturn(Optional.of(tech));
		mvc.perform(get("api/technology/1").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name", is(tech.getTechName())));
		mvc.perform(get("api/technology/72").contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isNotFound())
			.andExpect(content().string(containsString("Technology Not Found")));
		
	}
	@Test
	void testFindAll() throws Exception
	{
		List<Technology> allTech = Arrays.asList(tech);

		given(techServ.findAll()).willReturn(allTech);

		mvc.perform(get("/api/matrix").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(1)))
			.andExpect(jsonPath("$[0].name", is(tech.getTechName())));
	}
	@Test
	void testGetByName() throws Exception
	{
		given(techServ.getByName("testy")).willReturn(Optional.of(tech));
		mvc.perform(get("api/technology/1").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name", is(tech.getTechName())));
	}
	
}
