package com.revature.model;

import java.io.Serializable;

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
	
	private static final long serialVersionUID = -8885803230398305320L;

	@Column(name="curriculum_id")
	private int curriculumId;
	
	@Column(name="topic_id")
	private int topicId;
	

}
