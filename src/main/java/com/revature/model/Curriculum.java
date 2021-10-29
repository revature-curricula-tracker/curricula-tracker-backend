package com.revature.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="curriculum")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curriculum implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8875201762940135665L;

	@Id
	@Column(name="curriculum_id", nullable = false, unique=true, updatable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int curriculumId;
	
	@OneToMany(mappedBy= "curriculum", cascade = CascadeType.ALL)
	//@JsonIgnore//Properties(value="curriculum", allowSetters=true)
	private Set<CurriculumTopic> curriculumTopics;
	
	
	@Length(min = 1)
	@NotBlank
	private String curriculumName;
	
	private int numWeeks;
	
	private int numDays;

	@Override
	public String toString() {
		return "Curriculum [curriculumId=" + curriculumId + ", curriculumTopics=" + curriculumTopics
				+ ", curriculumName=" + curriculumName + ", numWeeks=" + numWeeks + ", numDays=" + numDays + "]";
	}
	
	
	

}
