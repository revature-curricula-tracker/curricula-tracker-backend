package com.revature.modelTests;



import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.springframework.boot.test.context.SpringBootTest;
import com.revature.model.Technology;
import com.revature.model.Topic;

@SpringBootTest(classes=Technology.class)
public class TechnologyTests {
	
	private Technology tech;
	
	@BeforeEach
	public void setup() {
		tech = new Technology(1, "name", new ArrayList<Topic>());
	}
	
	@AfterEach
	public void teardown() {
		tech = null;
	}
	
	@Test
	public void testGetIdReturnsId() {
		int dummyId = 1;
		assertEquals(dummyId, tech.getTechId());
	}
	
	@Test
	public void testSetIdChangesId() {
		int dummyId = 2;
		tech.setTechId(dummyId);
		assertEquals(dummyId, tech.getTechId());
	}
	
	@Test
	public void testGetNameReturnsName() {
		String dummyName = "name";
		assertEquals(dummyName, tech.getTechName());
	}
	
	@Test
	public void testSetNameChangesName() {
		String dummyName = "rename";
		tech.setTechName(dummyName);
		assertEquals(dummyName, tech.getTechName());
	}
	
	@Test
	public void testGetTopicsReturnsTopics() {
		List<Topic> dummyTopics = new ArrayList<Topic>();
		assertEquals(dummyTopics, tech.getTopics());
	}
	
	//TODO : add a setTopics test
	

}
