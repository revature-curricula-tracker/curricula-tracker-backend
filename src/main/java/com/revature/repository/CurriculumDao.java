package com.revature.repository;

import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.model.Curriculum;

@Repository
public interface CurriculumDao extends JpaRepository<Curriculum, Integer> {
	
	
	public Optional<Curriculum> getByCurriculumId(int id);
	
	public Curriculum getByCurriculumName(String curriculumName);
	
	public void deleteByCurriculumId(int id);
	
	public void deleteByCurriculumName(String name);

}
