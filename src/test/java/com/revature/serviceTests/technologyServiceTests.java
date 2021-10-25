package com.revature.serviceTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
class technologyServiceTests {
	
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
	public void testGetByIdReturnsTechnology() {
		Optional<Technology> expected = tech1;
		when(techdao.findById(1)).thenReturn(tech1);
		assertEquals(expected.get(), techserv.getById(1).get());
	}
	
	@Test
	public void testGetByNameReturnsTechnology() {
		Optional<Technology> expected = tech1;
		when(techdao.getByName("java")).thenReturn(tech1);
		assertEquals(expected, techserv.getByName("java"));
	}
	
	@Test
	public void testSaveReturnsTechnology() {
		Technology expected = tech2;
		when(techdao.save(tech2)).thenReturn(tech2);
		assertEquals(expected, techserv.insertTechnology(tech2));
	}
	
	@Test
	public void testDelete() {
		this.techserv.deleteTechnology(this.tech2.getTechId());
	}
	
	/*
	@Test
	public void testDeleteError() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> techserv.deleteTechnology(-5));
		assertThat(exception).hasMessageThat().contains("woops!");
	}
	*/
	
	@Test
	public void testUpdateReturnsTechnology() {
		when(techdao.save(tech2)).thenReturn(tech2);
		techdao.save(tech2);
		tech2.setTechName("html");
		assertEquals(tech2, techserv.update(tech2));
	}
	
	/*
	@Test
	public void testUpdateThrowsIllegalArgumentException() {
		System.out.println(techserv.update(null));
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> techserv.update(null));
		assertEquals("TechId cannot be less than 0", exception.getMessage());
	}
	*/
	
	@Test
	public void testFindAllReturnsAllTechnologys() {
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
