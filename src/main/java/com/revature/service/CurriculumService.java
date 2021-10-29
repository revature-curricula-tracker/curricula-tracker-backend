package com.revature.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Curriculum;
import com.revature.repository.CurriculumDao;
import com.revature.repository.CurriculumTopicDao;

@Service
public class CurriculumService {

	@Autowired
	private CurriculumDao cDAO;
	@Autowired
	private CurriculumTopicDao ctDAO;

	/**
	 * Saves a new Curriculum object in the database, and then returns the saved Curriculum.
	 * @param c		the Curriculum object to be saved
	 * @return		the Curriculum object that was saved
	 */
	public Curriculum insert(@Valid Curriculum c) {
		return cDAO.save(c);
	}

	/**
	 * Returns a list of all Curriculum stored in the database.
	 * @return		a list of all Curriculum
	 */
	@Transactional(readOnly = true)
	public List<Curriculum> findAll() {
		return cDAO.findAll();
	}

	/**
	 * Returns a Curriculum object if one exists with the specified id.
	 * @param id	the id of the Curriculum
	 * @return		the Curriculum object with the correlating id
	 */
	@Transactional(readOnly = true)
	public Curriculum getById(int id) {
		return cDAO.findByCurriculumId(id);
	}

	/**
	 * Returns the Curriculum with the specified name.
	 * @param name		the name of the Curriculum
	 * @return			the Curriculum object with the correlating name
	 */
	@Transactional(readOnly = true)
	public Curriculum getByCurriculumName(String name) {
		return cDAO.findByCurriculumName(name);
	}

	/**
	 * Deletes a specified Curriculum object in the database based on the id.
	 * @param id	the id of the Curriculum object to be deleted
	 */
	public void removeById(int id) {
		ctDAO.deleteByCuriculumId(id);
		cDAO.deleteById(id);
	}

	/**
	 * Updates a Curriculum object in the database then returns the updated object.
	 * @param c		The Curriculum to be updated in the database
	 * @return		The Technology object that has been updated
	 */
	public Curriculum update(@Valid Curriculum c) {
		return cDAO.save(c);
	}

}
