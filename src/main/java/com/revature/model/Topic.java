package com.revature.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "topic")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true, updatable = false)
	private int id;
	
	@Length(min=1)
	private String name;

	@ManyToMany (mappedBy = "curriculum_topic_join_table")
	Set<Curriculum> curriculum;
	
	@JoinColumn()
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties(value="topics", allowSetters=true)
	private Technology technology;

	public Topic(int id, @Length(min = 1) String name, Technology technology) {
		super();
		this.id = id;
		this.name = name;
		this.curriculum = new HashSet<Curriculum>();
		this.technology = technology;
	}
	
	public Topic(@Length(min = 1) String name, Technology technology) {
		super();
		this.name = name;
		this.curriculum = new HashSet<Curriculum>();
		this.technology = technology;
	}
	
	
}
