package com.revature.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Curriculum;
import com.revature.repository.CurriculumDao;

@Service
public class CurriculumService {

	@Autowired
	private CurriculumDao cDAO;

	public Curriculum insert(@Valid Curriculum c) {
		return cDAO.save(c);
	}

	@Transactional(readOnly = true)
	public List<Curriculum> findAll() {
		return cDAO.findAll();
	}

	@Transactional(readOnly = true)
	public Curriculum getById(int id) {
		return cDAO.findByCurriculumId(id);
	}

	@Transactional(readOnly = true)
	public Curriculum getByCurriculumName(String name) {
		return cDAO.findByCurriculumName(name);
	}

	public void removeById(int id) {
		cDAO.deleteById(id);
	}

	public Curriculum update(@Valid Curriculum c) {
		return cDAO.save(c);
	}

}
