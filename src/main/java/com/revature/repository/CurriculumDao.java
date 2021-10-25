package com.revature.repository;

import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.model.Curriculum;

@Repository
public interface CurriculumDao extends JpaRepository<Curriculum, Integer> {
	
	public Optional<Set<Curriculum>> getAll();
	
	public Optional<Curriculum> getById(int id);
	
	public Optional<Curriculum> getByName(String name);
	
	public void deleteById(int id);
	
	public void deleteByName(String name);

}
