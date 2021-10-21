package com.revature.modelTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.model.Curriculum;
import com.revature.model.Technology;
import com.revature.model.Topic;

@SpringBootTest
public class CurriculumTests {
	private Curriculum c;
	@Before
	public void setup() {
		c = new Curriculum(1,"Curricutastic",1,1);
	}
	
	@After
	public void teardown() {
		c = null;
		
	}
	
	@Test
	public void contextLoads() {
	}
	@Test
	public void GetCurriculumIdTest() {
		
		assertEquals(1,c.getCurriculumId());
	}
	@Test
	public void  GetCurriculumNameTest() {
		
		assertEquals("Curricutastic",c.getCurriculumName());
	}
	@Test
	public void  GetCurriculumNumWeeksTest() {
			
			assertEquals(1,c.getNum_weeks());
		}
	@Test
	public void  GetCurriculumNumDaysTest() {
			
			assertEquals(1,c.getNum_days());
	}
}
