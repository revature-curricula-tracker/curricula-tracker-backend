package com.revature.modelTests;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.model.Curriculum;

@SpringBootTest(classes=Curriculum.class)
public class CurriculumTests {
	private Curriculum c;
	@BeforeEach
	public void setup() {
		c = new Curriculum(1,"Curricutastic",1,1);
	}
	
	@AfterEach
	public void teardown() {
		c = null;
		
	}
	@Test
	void contextLoads() {
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
	@Test
	public void  SetCurriculumNumDaysTest() {
			c.setNum_days(2);
			assertEquals(2,c.getNum_days());
	}
	@Test
	public void  SetCurriculumNumWeeksTest() {
			c.setNum_weeks(2);
			assertEquals(2,c.getNum_weeks());
	}
}
