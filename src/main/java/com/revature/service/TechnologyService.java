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
	private TechnologyDao tDao;
	private Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * Returns a list of all Technologies stored in the database.
	 * @return		a list of all Technologies
	 */
	@Transactional(readOnly = true)
	public List<Technology> findAll() {
		return this.tDao.findAll();
	}

	/**
	 * Return the Technology with the specified id.
	 * @param id	the id of the Technology
	 * @return		the Technology object with the correlating id
	 */
	@Transactional(readOnly = true)
	public Optional<Technology> getById(final int id) {
		return this.tDao.findById(id);
	}

	/**
	 * Returns the Technology with the specified name.
	 * @param name		the name of the Technology
	 * @return			the Technology object with the correlating name
	 */
	@Transactional(readOnly = true)
	public Optional<Technology> getByName(final String name) {
		return this.tDao.getByTechName(name).isPresent() ? this.tDao.getByTechName(name) : Optional.empty();
	}

	/**
	 * Saves a new Technology object in the database, and then returns the saved Technology. 
	 * @param t		the Technology object to be saved
	 * @return		the Technology object that was saved
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Technology insertTechnology(final Technology t) {
		return this.tDao.save(t);
	}

	/**
	 * Deletes a specified Technology object in the database if it exists and returns true.
	 * If the Technology does not exist it will log.warn("ID can't be pulled.") and return false.
	 * @param id	the id of the Technology object to be deleted
	 * @return		true if the deletion is successful or false if unsuccessful
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean deleteTechnology(final int id) {
		try {
			if (id < 0) {
				throw new IllegalArgumentException("TechId cannot be less than 0");
			}
			this.tDao.deleteById(id);
			return true;
		} catch (final IllegalArgumentException e) {
			this.log.warn("ID can't be pulled.");
			return false;
		}
	}

	/**
	 * Updates a Technology object in the database, and then returns the updated Technology.
	 * If the Technology is not present it will throw IllegalArgumentException() and log.warn("Technology can't be found, update failed."), then return null.
	 * @param tech		The Technology to be updated in the database
	 * @return			The Technology object that has been updated, or null if the Technology does not exist in the database
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Technology update(final Technology tech) {

		try {

			final Optional<Technology> foundTech = this.tDao.findById(tech.getTechId());
			if (foundTech.isPresent()) {
				return this.tDao.save(tech);
			} else {
				throw new IllegalArgumentException();
			}
		}

		catch (final IllegalArgumentException e)

		{

			this.log.warn("Technology can't be found, update failed.");
			return null;
		}
	}
}
