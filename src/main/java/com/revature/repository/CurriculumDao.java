package com.revature.repository;

import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.model.Curriculum;

@Repository
public interface CurriculumDao extends JpaRepository<Curriculum, Integer> {
	
	public void deleteByCurriculumName(String name);
	
	public Curriculum findByCurriculumName(String name);

	public Curriculum findByCurriculumId(int id);
 
}
