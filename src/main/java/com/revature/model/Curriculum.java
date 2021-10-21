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

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="curriculum")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curriculum {
	
	@Id
	@Column(name="curriculum_id", nullable = false, unique=true, updatable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ManyToMany
	@JoinTable(name="curriculum_tech_join_table", 
	joinColumns = @JoinColumn(name = "curriculum_id"),
	inverseJoinColumns = @JoinColumn(name = "tech_id"))
	private int curriculumId;
	
	@Length(min = 1)
	@NotBlank
	private String curriculumName;
	
	private int num_weeks;
	
	
	

}
