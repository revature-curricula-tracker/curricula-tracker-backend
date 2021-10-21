package com.revature.service;

import java.util.Set;
import java.util.stream.Collectors;

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
	@Autowired private TechnologyDao tDao;
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Transactional(readOnly = true)
	public Set<Technology> findAll()
	{
		return tDao.findAll().stream().collect(Collectors.toSet());
	}
	@Transactional(readOnly = true)
	public Technology findById(int id)
	{
		return tDao.findById(id).orElseThrow(() -> new TechnologyNotFoundException("No technology found with id " + id));
	}
	@Transactional(readOnly = true)
	public Technology getById(int id)
	{
		return tDao.getById(id);
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Technology insertTechnology(Technology t)
	{
		return tDao.save(t);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteTechnology(int id)
	{
		try
		{
			tDao.deleteById(id);
		}
		catch(IllegalArgumentException e)
		{
			log.warn("ID can't be pulled.");
		}
	}
}
