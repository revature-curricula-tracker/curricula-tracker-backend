package com.revature.service;

import java.util.Optional;
import java.util.Set;

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
	public Optional<Set<Technology>> findAll() {
		return tDao.getAll();
	}

	@Transactional(readOnly = true)
	public Optional<Technology> getById(int id) {
		return tDao.getById(id);
	}
	
	@Transactional(readOnly = true)
	public Optional<Technology> getByName(String name)
	{
		return Optional.of(tDao.getByName(name)
				.orElseThrow(() -> new TechnologyNotFoundException("No technology found with name: " + name)));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Technology insertTechnology(Technology t) {
		return tDao.save(t);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteTechnology(int id) {
		try {
			tDao.deleteById(id);
		} catch (IllegalArgumentException e) {
			log.warn("ID can't be pulled.");
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Technology tech)
	{
		try
		{
			tDao.save(tech);
		}
		catch(IllegalArgumentException e)
		{
			log.warn("Technology can't be found, update failed.");
		}
	}
}
