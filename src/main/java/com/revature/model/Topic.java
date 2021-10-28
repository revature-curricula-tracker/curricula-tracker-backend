package com.revature.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "topic")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3251404690818761188L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true, updatable = false)
	private int id;
	
	@Length(min=1)
	private String name;
	
	@Length(min=1, max=1000)
	private String description;

	@OneToMany(mappedBy= "topic", cascade = CascadeType.ALL)
	@JsonIgnore//Properties(value="topic", allowSetters=true)
	private Set<CurriculumTopic> curriculumTopics;
	
	@JoinColumn()
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value="topics", allowSetters=true)
	private Technology technology;
}
