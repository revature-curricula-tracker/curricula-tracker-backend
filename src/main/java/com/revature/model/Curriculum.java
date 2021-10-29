package com.revature.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="curriculum")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curriculum implements Serializable {
	
	private static final long serialVersionUID = -8875201762940135665L;

	@Id
	@Column(name="curriculum_id", nullable = false, unique=true, updatable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int curriculumId;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="curriculum", cascade = CascadeType.REMOVE)
	private List<Topic> topics;
	
	@Length(min = 1)
	@NotBlank
	private String curriculumName;
	
	private int numWeeks;
	
	private int numDays;
	
}
