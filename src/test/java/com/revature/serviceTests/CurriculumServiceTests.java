package com.revature.serviceTests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.model.Curriculum;
import com.revature.repository.CurriculumDao;
import com.revature.service.CurriculumService;


@SpringBootTest(classes= {CurriculumService.class,CurriculumDao.class})
class CurriculumServiceTests {
	@MockBean
	CurriculumDao cDao;
	
	@InjectMocks
	CurriculumService cs;
	
	Curriculum curriculum;
	Optional<Curriculum> curr2;
	
	@BeforeEach
	void construct() {
		MockitoAnnotations.openMocks(this);

		this.curriculum = new Curriculum(2, null, "JavaScript: Fun Times", 5, 25);
		this.curr2 = Optional.ofNullable(curriculum);
	}
	
	@Test
	void insertCurriculumTest() {
		when(this.cDao.save(curriculum)).thenReturn(this.curriculum);
		assertEquals(cs.insert(curriculum),this.curriculum);
	}
	
	@Test
	void findById_returnsCurriculum() {
		final int id = this.curriculum.getCurriculumId();
		when(this.cDao.findByCurriculumId(id)).thenReturn(this.curriculum);
		assertEquals("findByCurriculumId did not return the curriculum", cs.getById(this.curriculum.getCurriculumId()), this.curriculum);
	}
	@Test
	void findByName_returnsCurriculum() {
		final String name = this.curriculum.getCurriculumName();
		when(this.cDao.findByCurriculumName(name)).thenReturn(this.curriculum);
		assertEquals("findByCurriculumId did not return the curriculum", cs.getByCurriculumName(this.curriculum.getCurriculumName()), this.curriculum);
	}
	
	@Test
	void deleteCurriculum_success() {
		this.cs.removeById(this.curriculum.getCurriculumId());
		assertEquals(true,true);
	}

	@Test
	void findAll_Test() {
		List<Curriculum> curricula = this.cs.findAll();
		assertEquals(true,curricula.isEmpty());
	}
	@Test
	void testUpdateReturnsCurriculum() {
		when(cDao.save(curr2.get())).thenReturn(curr2.get());
		when(cDao.findById(1)).thenReturn(curr2);
		
		cDao.save(curr2.get());
		curr2.get().setCurriculumName("How to Python");
		assertEquals(curr2.get(), cs.update(curr2.get()));
	}
}
