package com.revature.modelTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.revature.model.CurriculumTopicKey;

public class CurriculumTopicKeyTests {
	
	private CurriculumTopicKey k;
	
	@Before
	public void setup() {
		k = new CurriculumTopicKey(3, 4);
	}

	@After
	public void teardown() {
		k = null;
	}
	
	@Test
	public void testGetCurriculumId()
	{
		assertEquals(k.getCurriculumId(), 3);
	}
	
	@Test
	public void testSetCurriculumId()
	{
		k.setCurriculumId(55);
		assertEquals(k.getCurriculumId(), 55);
	}
	
	@Test
	public void testGetTopicId()
	{
		assertEquals(k.getTopicId(), 4);
	}
	
	@Test
	public void testSetTopicId()
	{
		k.setTopicId(22);
		assertEquals(k.getTopicId(), 22);
	}

}
