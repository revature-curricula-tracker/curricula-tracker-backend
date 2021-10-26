package com.revature.serviceTests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.model.Technology;
import com.revature.model.Topic;
import com.revature.repository.TechnologyDao;
import com.revature.service.TechnologyService;

@SpringBootTest(classes= {TechnologyService.class, TechnologyDao.class})
class TechnologyServiceTests {
	
	@MockBean
	TechnologyDao techdao;
	
	@InjectMocks
	TechnologyService techserv;
	
	Optional<Technology> tech1;
	Technology tech2;
	Technology tech3;
	
	
	@BeforeEach
	void construct() {
		MockitoAnnotations.openMocks(this);

		this.tech1 = Optional.ofNullable(new Technology(1, "java", new ArrayList<Topic>()));
		this.tech2 = new Technology(2, "sql", new ArrayList<Topic>());
		this.tech3 = new Technology(3, "javascript", new ArrayList<Topic>());
	}
	
	@Test
	void testGetByIdReturnsTechnology() {
		Optional<Technology> expected = tech1;
		when(techdao.findById(1)).thenReturn(tech1);
		assertEquals(expected.get(), techserv.getById(1).get());
	}
	
	@Test
	void testGetByNameReturnsTechnology() {
		Optional<Technology> expected = tech1;
		when(techdao.getByTechName("java")).thenReturn(tech1);
		assertEquals(expected, techserv.getByName("java"));
	}
	
	@Test
	void testSaveReturnsTechnology() {
		Technology expected = tech2;
		when(techdao.save(tech2)).thenReturn(tech2);
		assertEquals(expected, techserv.insertTechnology(tech2));
	}
	
	@Test
	void testDelete() {
		assertEquals(true, techserv.deleteTechnology(1));
	}
	
	
	@Test
	void testDeleteError() {
		assertEquals(false, techserv.deleteTechnology(-5));
	}
	
	@Test
	void testUpdateReturnsTechnology() {
		when(techdao.save(tech1.get())).thenReturn(tech1.get());
		when(techdao.findById(1)).thenReturn(tech1);
		
		techdao.save(tech1.get());
		tech1.get().setTechName("html");
		assertEquals(tech1.get(), techserv.update(tech1.get()));
	}
	
	
	@Test
	void testUpdateThrowsIllegalArgumentException() {
		when(techdao.findById(-4)).thenReturn(Optional.empty());
		
		tech1.get().setTechId(-4);;
		assertEquals(null, techserv.update(tech1.get()));
	}
	
	
	@Test
	void testFindAllReturnsAllTechnologys() {
		List<Technology> techs = new LinkedList<Technology>();
		techs.add(tech2);
		techs.add(tech3);

		when(techdao.save(tech2)).thenReturn(tech2);
		when(techdao.save(tech3)).thenReturn(tech3);
		when(techdao.findAll()).thenReturn(techs);
		
		techdao.save(tech2);
		techdao.save(tech3);
		
		assertEquals(true, techserv.findAll().equals(techs));
	}

	
	
}
