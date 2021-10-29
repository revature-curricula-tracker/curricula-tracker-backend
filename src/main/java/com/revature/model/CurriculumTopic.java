package com.revature.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CurriculumTopic implements Serializable {
	

	    @EmbeddedId
	    private CurriculumTopicKey curriculumTopicKey;

	    @ManyToOne
	    @MapsId("curriculumId")
	    @JoinColumn(name = "curriculum_id")
		@JsonIgnoreProperties(value="curriculumTopics", allowSetters=true)
	    private Curriculum curriculum;

	    @ManyToOne
	    @MapsId("topicId")
	    @JoinColumn(name = "topic_id")
		@JsonIgnoreProperties(value={"curriculumTopics"}, allowSetters=true)
	    private Topic topic;

	    private int topicDay;
	    
	    // standard constructors, getters, and setters
	}
