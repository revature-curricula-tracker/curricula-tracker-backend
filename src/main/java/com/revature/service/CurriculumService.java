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
	//CurriculumDao object to call methods that directly access the repository
	private CurriculumDao cDAO;

	/*
	 * inserts Curriculum into repository
	 * @param c = Curriculum to be inserted into repository
	 * @return = Curriculum inserted
	 */
	public Curriculum insert(@Valid Curriculum c) {
		return cDAO.save(c);
	}

	@Transactional(readOnly = true)
	/*
	 * returns a list containing all Curriculum
	 * @return = list containing all Curriculum
	 */
	public List<Curriculum> findAll() {
		return cDAO.findAll();
	}

	@Transactional(readOnly = true)
	/*
	 * returns the Curriculum with the corresponding id
	 * @param id = unique integer signifying Curriculum searched for
	 * @return = Curriculum from repository with id == id
	 */
	public Curriculum getById(int id) {
		return cDAO.findByCurriculumId(id);
	}

	@Transactional(readOnly = true)
	/*
	 * returns the Curriculum with the given name
	 * @param name = name of Curriculum being searched for in repository
	 * @return = Curriculum from repository with name == name
	 */
	public Curriculum getByCurriculumName(String name) {
		return cDAO.findByCurriculumName(name);
	}

	/*
	 * take a wild guess, or just read the spoiler on the following line:
	 * removes Curriculum with the input id
	 * @param id = unique integer signifying Curriculum being deleted
	 */
	public void removeById(int id) {
		cDAO.deleteById(id);
	}

	/*
	 * saves input Curriculum to repository
	 * @param c = Curriculum being updated to repository
	 * @return = updated curriculum from the repository
	 */
	public Curriculum update(@Valid Curriculum c) {
		return cDAO.save(c);
	}

}
