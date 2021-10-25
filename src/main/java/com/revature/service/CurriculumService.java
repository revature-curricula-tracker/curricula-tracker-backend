package com.revature.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
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
	
	@Transactional(readOnly=true)
	public Set<Curriculum> findAll() {
		return cDAO.findAll().stream().collect(Collectors.toSet());
	}
	
	@Transactional(readOnly=true)
	public Optional<Curriculum> getById(int id) {
		return cDAO.getById(id);
	}
	
	@Transactional(readOnly=true)
	public Optional<Curriculum> getByName(String name) {
		return cDAO.getByName(name);
	}

	public void removeById(int id) {
		try {
			cDAO.deleteById(id);
		} catch (IllegalArgumentException e) {
			//logger.warn("id can't be null to deleteById()");
		}
	}

	public void removeByName(String name) {
		try {
			cDAO.deleteByName(name);
		} catch (IllegalArgumentException e) {
			//logger.warn("id can't be null to deleteById()");
		}
	}

	public Curriculum update(@Valid Curriculum c) {
		return cDAO.save(c);
	}

}
