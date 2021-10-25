package com.revature.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.exceptions.CurriculumTopicNotFoundException;
import com.revature.model.Curriculum;
import com.revature.model.CurriculumTopic;
import com.revature.model.Topic;
import com.revature.repository.CurriculumTopicDao;

@Service
public class CurriculumTopicService {
	
	@Autowired
	private CurriculumTopicDao curriculumTopicDao;
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Transactional(readOnly = true)
	public Set<CurriculumTopic> findAll() {
		return curriculumTopicDao.findAll().stream().collect(Collectors.toSet());
	}
	
	@Transactional(readOnly = true)
	public Optional<Set<CurriculumTopic>> getAllByCurriculum(Curriculum curriculum) {
		return curriculumTopicDao.getAllByCurriculum(curriculum);
	}
	
	@Transactional(readOnly = true)
	public Optional<Set<CurriculumTopic>> getAllByTopic(Topic topic) {
		return curriculumTopicDao.getAllByTopic(topic);
	}
	
	@Transactional(readOnly = true)
	public Optional<Set<CurriculumTopic>> getAllByTopicDay(int topic_day) {
		return curriculumTopicDao.getAllTopicsByTopicDay(topic_day);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public CurriculumTopic insertCurriculumTopic(CurriculumTopic c) {
		return curriculumTopicDao.save(c);
	}
	
//	@Transactional(propagation = Propagation.REQUIRED)
//	public void deleteCurriculum(CurriculumTopicKey curriculumTopicKey) {
//		try {
//			curriculumTopicDao.deleteById(curriculumTopicKey);
//		} catch (IllegalArgumentException e) {
//			log.warn("ID can't be pulled.");
//		}
//	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(CurriculumTopic ct)
	{
		try
		{
			curriculumTopicDao.save(ct);
		}
		catch(CurriculumTopicNotFoundException e)
		{
			log.warn("Curriculum Topic can't be found, update failed.");
		}
	}
	
	
	
	
	
	
}
