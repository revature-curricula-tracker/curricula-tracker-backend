package com.revature.repository;

import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.model.Technology;

@Repository
public interface TechnologyDao extends JpaRepository<Technology, Integer>{
}
