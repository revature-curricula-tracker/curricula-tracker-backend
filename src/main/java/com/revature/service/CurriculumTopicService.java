package com.revature.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.CurriculumTopic;
import com.revature.model.CurriculumTopicKey;
import com.revature.repository.CurriculumTopicDao;

@Service
public class CurriculumTopicService {	

	@Autowired
	private CurriculumTopicDao ctDAO;

	public CurriculumTopic insert(@Valid CurriculumTopic ct) {
		return ctDAO.save(ct);
	}
	
	@Transactional(readOnly = true)
	public List<CurriculumTopic> findAll() {
		return ctDAO.findAll();
	}
	
	@Transactional
	public boolean removeByIds(int curriculumId, int topicId) {
		CurriculumTopicKey id = new CurriculumTopicKey();
		id.setCurriculumId(curriculumId);
		id.setTopicId(topicId);
		
		try {
			findByIds(curriculumId, topicId); 
			if (findByIds(curriculumId, topicId) == null) {
				throw new IllegalArgumentException(); 
			}
			ctDAO.delete(new CurriculumTopic(id, null, null, 0));
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
	
	@Transactional(readOnly = true)
	public CurriculumTopic findByIds(int curriculumId, int topicId) {
		CurriculumTopicKey id = new CurriculumTopicKey();
		id.setCurriculumId(curriculumId);
		id.setTopicId(topicId);
		return ctDAO.findByCurriculumTopicKey(id);
	}
	
	public List<CurriculumTopic> findByCurriculumId(int id){
		return ctDAO.findByCuriculumId(id);
	}
}
