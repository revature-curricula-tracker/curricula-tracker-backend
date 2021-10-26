package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Technology;
import com.revature.repository.TechnologyDao;

@Service
public class TechnologyService {
	@Autowired
	/*
	 * @param tDao = TechnologyDao object to call methods directly accessing the repository
	 * @param log = for logging what happens
	 */
	private TechnologyDao tDao;
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Transactional(readOnly = true)
	/*
	 * finds all technologies in the repository and returns them in a list
	 * @return = List of all Technology in the repository
	 */
	public List<Technology> findAll() {
		return tDao.findAll();
	}

	@Transactional(readOnly = true)
	/*
	 * finds technology based on an unique id integer and returns it as an Optional
	 * @param id = unique integer representing Technology being searched for
	 * @return = Technology from repository with id == id
	 */
	public Optional<Technology> getById(int id) {
		return tDao.findById(id);
	}

	@Transactional(readOnly = true)
	/*
	 * finds technology based on given name and returns it as an Optional
	 * @param name = name of the Technology being searched for
	 * @return = Optional of the Technology from the repository with name == name
	 */
	public Optional<Technology> getByName(String name) {
		return tDao.getByTechName(name).isPresent() ? tDao.getByTechName(name) : Optional.empty();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	/*
	 * inserts a given Technology into the repository
	 * @param t = Technology being inserted into repository
	 * @return = inserted Technology
	 */
	public Technology insertTechnology(Technology t) {
		return tDao.save(t);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	/*
	 * deletes a Technology with the given id from the repository, throwing IllegalArguementException
	 * if the id is invalid and can't be pulled
	 * @param id = unique integer signifying Technology to be deleted
	 * @return = true or false depending on whether or not Technology with id == id could be deleted
	 */
	public boolean deleteTechnology(int id) {
		try {
			if (id < 0) {
				throw new IllegalArgumentException("TechId cannot be less than 0");
			}
			tDao.deleteById(id);
			return true;
		} catch (IllegalArgumentException e) {
			log.warn("ID can't be pulled.");
			return false;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	/*
	 * updates the input technology in the repository, finding it based on its id and then saving the new 
	 * input over it, throwing IllegalArguementException if it can't
	 * @param tech = Technology being updated to the repository
	 * @param foundTech = Optional that determines if input Technology exists in repository
	 * @return = updated Technology from the repository
	 */
	public Technology update(Technology tech) {

		try {

			Optional<Technology> foundTech = tDao.findById(tech.getTechId());
			if (foundTech.isPresent()) {
				return tDao.save(tech);
			} else {
				throw new IllegalArgumentException();
			}
		}

		catch (IllegalArgumentException e)

		{

			log.warn("Technology can't be found, update failed.");
			return null;
		}
	}
}
