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
	private TechnologyDao tDao;
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Transactional(readOnly = true)
	public List<Technology> findAll() {
		return tDao.findAll();
	}

	@Transactional(readOnly = true)
	public Optional<Technology> getById(int id) {
		return tDao.findById(id);
	}
	
	@Transactional(readOnly = true)
	public Optional<Technology> getByName(String name)
	{
		return tDao.getByName(name);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Technology insertTechnology(Technology t) {
		return tDao.save(t);
	}

	@Transactional(propagation = Propagation.REQUIRED)
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
	public Technology update(Technology tech) {

		try {
		
			Optional<Technology> foundTech = tDao.findById(tech.getTechId());
			if (foundTech.isPresent()) {
				return tDao.save(tech);
			} else {
				throw new IllegalArgumentException();
			}
		}
		catch(IllegalArgumentException e) {
			log.warn("Technology can't be found, update failed.");
			return null;
		}
	}
}
