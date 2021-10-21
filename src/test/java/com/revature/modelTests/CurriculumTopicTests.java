package com.revature.modelTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.model.CurriculumTopic;
import com.revature.model.CurriculumTopicKey;

public class CurriculumTopicTests {

	private CurriculumTopic c;

	@Before
	public void setup() {
		c = new CurriculumTopic(new CurriculumTopicKey(3, 4), 14, 4, 12);
	}

	@After
	public void teardown() {
		c = null;
	}

	@Test
	public void testGet_CurriculumTopicKey
	{
		CurriculumTopicKey t = new CurriculumTopicKey(3, 4);
		assertEquals(c.getCurriculumTopicKey(), t);
	}

	@Test
	public void testGet_CurriculumId
	{
		assertEquals(c.getCurriculumId(), 14);
	}

	@Test
	public void testGet_TopicId
	{
		assertEquals(c.getTopic_id(), 4);
	}

	@Test
	public void testGet_TopicDays
	{
		assertEquals(c.getTopic_day(), 12);
	}

	@Test
	public void testSet_CurriculumTopicKey
	{
		CurriculumTopicKey k = new CurriculumTopicKey(12, 12);
		c.setCurriculumTopicKey(k);
		assertTrue(c.getCurriculumTopicKey() == k);
	}

	@Test
	public void testSet_CurriculumId
	{
		c.setCurriculumId(110);
		assertEquals(c.getCurriculumId(), 110);
	}

	@Test
	public void testSet_TopicId
	{
		c.setTopic_id(25);
		assertEquals(c.getTopic_id(), 25);
	}

	@Test
	public void testSet_TopicDays
	{
		c.setTopic_day(3);
		assertEquals(c.getTopic_day(), 3);
	}

}
