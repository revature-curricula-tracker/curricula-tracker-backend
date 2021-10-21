package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

<<<<<<< HEAD
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="curriculum")
@Data
@NoArgsConstructor
@AllArgsConstructor
=======

@Entity
>>>>>>> d833b37a4acbe118a6d41b40440b70fdf16a0f23
public class Curriculum {
	
	@Id
	@Column(name="curriculum_id", nullable = false, unique=true, updatable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ManyToMany
	@JoinTable(name="curriculum_tech_join_table", 
	joinColumns = @JoinColumn(name = "curriculum_id"),
	inverseJoinColumns = @JoinColumn(name = "topic_id"))
	private int curriculumId;
	
	@Length(min = 1)
	@NotBlank
	private String curriculumName;
	
	private int num_weeks;
	
	private int num_days;
	
	
	

}
