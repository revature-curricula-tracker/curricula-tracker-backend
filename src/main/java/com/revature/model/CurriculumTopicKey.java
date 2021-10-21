package com.revature.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CurriculumTopicKey implements Serializable {
	
	@Column(name="curriculum_id")
	private int curriculumId;
	
	@Column(name="topic_id")
	private int topicId;
	

}
