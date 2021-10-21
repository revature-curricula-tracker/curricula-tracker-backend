package com.revature.modelTests;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.model.Topic;
import com.revature.model.Curriculum;
import com.revature.model.Technology;

@SpringBootTest
public class TopicTests {
	
	private Topic topic;
	private Technology tech;
	
	@Before
	public void setup() {
		
		topic = new Topic(1, "name", tech);
	}
	
	@After
	public void teardown() {
		tech = null;
	}
	
	@Test
	public void testGetIdReturnsId() {
		int dummyId = 1;
		assertEquals(dummyId, topic.getId());
	}
	
	@Test
	public void testSetIdChangesId() {
		int dummyId = 2;
		topic.setId(dummyId);
		assertEquals(dummyId, topic.getId());
	}
	
	@Test
	public void testGetNameReturnsName() {
		String dummyName = "name";
		assertEquals(dummyName, topic.getName());
	}
	
	@Test
	public void testSetNameChangesName() {
		String dummyName = "rename";
		topic.setName(dummyName);
		assertEquals(dummyName, topic.getName());
	}
	
	@Test
	public void testGetCurriculumReturnsCurriculum() {
		Set<Curriculum> dummySet = new HashSet<>();
		assertEquals(dummySet, topic.getCurriculum());
	}
	
	@Test
	public void testGetTechnologyReturnsTechnology() {
		assertEquals(tech, topic.getTechnology());
	}
	
}
