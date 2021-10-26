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
	
//	public void removeByIds(int curriculumId, int topicId) {
//		ctDAO.CurriculumTopicDelete(new CurriculumTopicKey(curriculumId, topicId));
//	}
}
