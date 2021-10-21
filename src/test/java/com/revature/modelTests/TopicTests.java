package com.revature.modelTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.model.Topic;
import com.revature.model.Curriculum;
import com.revature.model.Technology;

@SpringBootTest(classes=Topic.class)
public class TopicTests {
	
	private Topic topic;
	private Technology tech;
	
	@BeforeEach
	public void setup() {
		
		topic = new Topic(1, "name", tech);
	}
	
	@AfterEach
	public void teardown() {
		tech = null;
	}
	
	@Test
	public void getIdReturnsIdTest() {
		int dummyId = 1;
		assertEquals(dummyId, topic.getId());
	}
	
	@Test
	public void setIdChangesIdTest() {
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
