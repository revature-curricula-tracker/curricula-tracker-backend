package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Technology;
import com.revature.repository.TechnologyDao;

@Service
public class TechnologyService {
	
	@Autowired
	private TechnologyDao technologyDao;
	
}