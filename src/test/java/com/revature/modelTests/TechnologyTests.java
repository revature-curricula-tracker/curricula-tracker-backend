package com.revature.modelTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
	
	@Before
	public void setup() {
		tech = new Technology(1, "name", new ArrayList<Topic>());
	}
	
	@After
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
	
	//TODO : add a setTopics test. Waiting on topic model.
	
	@Test
	public void testEquals() {
		Technology t = new Technology(1, "name", new ArrayList<Topic>());
		assertTrue(t.equals(tech));
	}
	
	@Test
	public void testHashCode() {
		Technology t = new Technology(1, "name", new ArrayList<Topic>());
		assertEquals(t.hashCode(), tech.hashCode());
	}
	
	
	

}
