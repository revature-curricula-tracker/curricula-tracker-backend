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
import com.revature.exceptions.TechnologyNotFoundException;

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
	 */
	public List<Technology> findAll() {
		return tDao.findAll();
	}

	@Transactional(readOnly = true)
	/*
	 * finds technology based on an unique id integer and returns it as an Optional
	 */
	public Optional<Technology> getById(int id) {
		return tDao.findById(id);
	}
	
	@Transactional(readOnly = true)
	/*
	 * finds technology based on given name and returns it as an Optional, throwing 
	 * TechnologyNotFoundException if it does not exist in the repository
	 */
	public Optional<Technology> getByName(String name)
	{
		return Optional.of(tDao.getByName(name)
				.orElseThrow(() -> new TechnologyNotFoundException("No technology found with name: " + name)));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	/*
	 * inserts a given Technology into the repository
	 */
	public Technology insertTechnology(Technology t) {
		return tDao.save(t);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	/*
	 * deletes a Technology with the given id from the repository, throwing IllegalArguementException
	 * if the id is invalid and can't be pulled
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

		catch(IllegalArgumentException e)

		{

			log.warn("Technology can't be found, update failed.");
			return null;
		}
	}
}
