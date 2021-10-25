package com.revature.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CurriculumTopic {
	

	    @EmbeddedId
	    CurriculumTopicKey curriculumTopicKey;

	    @ManyToOne
	    @MapsId("curriculum_id")
	    @JoinColumn(name = "curriculum_id")
	   	Curriculum curriculum;

	    @ManyToOne
	    @MapsId("topic_id")
	    @JoinColumn(name = "topic_id")
	    Topic topic;

	    private int topicDay;
	    
	    // standard constructors, getters, and setters
	}
