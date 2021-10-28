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
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "technology")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Technology implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 948887999117032042L;

	/*
	 * contains a generated integer techId that is unique to each Technology
	 */
	@Id
	@Column(name = "tech_id", nullable = false, unique = true, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int techId;
	
	/*
	 * contains unique name for the Technology
	 */
	@Length(min = 1)
	@NotBlank
	private String techName;
	
	
	/*
	 * contains a list with all Topics included in the Technology
	 */
	//@EqualsAndHashCode.Exclude
	//@ToString.Exclude
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="technology")
	@JsonIgnoreProperties(value="technology", allowSetters=true)
	private List<Topic> topics;
	
	/*
	 * the color of the Technology
	 */
	private String color;
}
