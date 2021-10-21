package com.revature.modelTests;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.revature.model.Technology;
import com.revature.model.Topic;

@SpringBootTest
public class TechnologyTests {
	
	private Technology tech;
	private Technology blankTech;
	
	@Before
	public void setup() {
		tech = new Technology(1, "name", new ArrayList<Topic>());
		blankTech = new Technology();
	}
	
	@After
	public void teardown() {
		tech = null;
		blankTech = null;
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
	public void testGetTopicsReturnsTopics() {
		List<Topic> dummyTopics = new ArrayList<Topic>();
		assertEquals(dummyTopics, tech.getTechName());
	}
	
	// in progress
	// TODO add custom error
	@Test
	public void testBlankNameThrowsError() {
		assertEquals(null, blankTech.getTechName());
	}
	
	

}
