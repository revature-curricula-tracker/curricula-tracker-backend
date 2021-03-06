package com.revature.serviceTests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.model.Topic;
import com.revature.repository.TopicDao;
import com.revature.service.TopicService;

@SpringBootTest(classes= {TopicService.class,TopicDao.class})
class TopicServiceTests {
	
	@MockBean
	TopicDao topicDao;
	
	@InjectMocks
	TopicService service;
	
	
	Topic topic;
	Topic topic_2;
	
	@BeforeEach
	void construct() {
		MockitoAnnotations.openMocks(this);

		this.topic = new Topic(1, 1, "Test Topic", "A Topic for testing.", null, null);
		this.topic_2 = new Topic(2, 1, "Another Test Topic", "A Topic for testing.", null, null);
	}
	
	@Test
	void findById_returnsTopic() {
		final int id = this.topic.getId();
		when(this.topicDao.findById(id)).thenReturn(Optional.of(this.topic));
		assertEquals("findById did not return the topic", this.service.findById(id), this.topic);
	}
	
	@Test
	void findByName_returnsTopics() {
		final List<Topic> list = new LinkedList<>();
		list.add(this.topic);
		
		when(this.topicDao.findByName(this.topic.getName()) ).thenReturn(list);
		assertEquals("findByName did not return the list of topics with the provided name", this.service.findByName(this.topic.getName()), list);
	}
	
	@Test
	void save_returnsTopic() {
		when(this.topicDao.save(this.topic) ).thenAnswer(i -> i.getArgument(0));
		assertEquals("save did not return the topic",this.service.save(this.topic),this.topic);
	}
	
	@Test
	void update_returnsTopic() {
		when(this.topicDao.save(this.topic) ).thenAnswer(i -> i.getArgument(0));
		assertEquals("update did not return the topic",this.service.update(this.topic),this.topic);
	}
	
	@Test
	void update_returnsTopics() {
		final List<Topic> list = new LinkedList<>();
		list.add(this.topic);
		
		when(this.topicDao.findByName(this.topic.getName()) ).thenReturn(list);
		assertEquals("update by name did not return the updated topics",this.service.updateByName(this.topic.getName(), this.topic), list);
	}
	
	@Test
	void deleteTopic_success() {
		this.service.delete(this.topic);
		assertEquals(1, this.topic.getId());
	}
	
	@Test
	void deleteId_success() {
		this.service.delete(this.topic.getId());
		assertEquals(1, this.topic.getId());
	}
	
	@Test
	void deleteByName_success() {
		this.service.deleteByName(this.topic.getName());
		assertEquals(1, this.topic.getId());
	}
	
	@Test
	void testFindAllReturnsAllTopics() {
		final List<Topic> topics = new LinkedList<Topic>();
		topics.add(this.topic);
		topics.add(this.topic_2);

		when(this.topicDao.save(topic)).thenReturn(topic);
		when(this.topicDao.save(topic_2)).thenReturn(topic_2);
		when(this.topicDao.findAll()).thenReturn(topics);
		
		this.topicDao.save(topic);
		this.topicDao.save(topic_2);
		
		assertEquals(true, this.service.findAll().equals(topics));
	}

}
