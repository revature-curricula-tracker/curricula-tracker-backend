package com.revature.serviceTests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.model.Curriculum;
import com.revature.model.CurriculumTopic;
import com.revature.model.CurriculumTopicKey;
import com.revature.model.Topic;
import com.revature.repository.CurriculumTopicDao;
import com.revature.service.CurriculumTopicService;

@SpringBootTest(classes= {CurriculumTopicService.class,CurriculumTopicDao.class})
class CurriculumTopicServiceTests {
	
	@MockBean
	CurriculumTopicDao ctDao;

	@InjectMocks
	CurriculumTopicService ctserv;

	CurriculumTopic ct;
	CurriculumTopicKey id;
	
	
	@BeforeEach
	void construct() {
		MockitoAnnotations.openMocks(this);

		this.id = new CurriculumTopicKey();
		id.setCurriculumId(1);
		id.setTopicId(1);
		this.ct = new CurriculumTopic(id, new Curriculum(), new Topic(), 1);
	}
	
	@Test
	void insertCurriculumTest() {
		when(this.ctDao.save(ct)).thenReturn(this.ct);
		assertEquals(ctserv.insert(ct), this.ct);
	}

	@Test
	void findAll_Test() {
		List<CurriculumTopic> cts = new ArrayList<CurriculumTopic>();
		cts.add(ct);
		
		when(this.ctDao.findAll()).thenReturn(cts);
		assertEquals(cts, ctserv.findAll());
	}
	
	@Test
	void findByCurriculumId_Test() {
		List<CurriculumTopic> cts = new ArrayList<CurriculumTopic>();
		cts.add(ct);
		
		when(this.ctDao.findByCuriculumId(1)).thenReturn(cts);
		assertEquals(cts, ctserv.findByCurriculumId(1));
	}
	
	@Test
	void findByIds_Test() {
		when(this.ctDao.findByCurriculumTopicKey(id)).thenReturn(ct);
		assertEquals(ct, ctDao.findByCurriculumTopicKey(id));
	}
	
	@Test
	void testRemoveByIds() {
		when(this.ctDao.findByCurriculumTopicKey(id)).thenReturn(ct);
		
		assertEquals(true, ctserv.removeByIds(1, 1));
	}
	
	@Test
	void testRemoveByIds_Error() {
		assertEquals(false, ctserv.removeByIds(1, 1));
	}
}
