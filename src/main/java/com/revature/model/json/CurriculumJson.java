package com.revature.model.json;

import java.util.Set;

import com.revature.model.Curriculum;
import com.revature.model.CurriculumTopic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurriculumJson {
	
	public CurriculumJson(final Curriculum cir) {
		this.curriculumId = cir.getCurriculumId();
		this.curriculumName = cir.getCurriculumName();
		this.numDays = cir.getNumDays();
		this.numWeeks = cir.getNumWeeks();
		
		for(final CurriculumTopic cirTop: cir.getCurriculumTopics()) {
			this.curriculumTopics.add( new CurriculumTopicJson(cirTop.getTopic(), cirTop.getTopicDay()) );
		}
	}

	private int curriculumId;
	private String curriculumName;
	private int numWeeks;
	private int numDays;
	private Set<CurriculumTopicJson> curriculumTopics;
	
}
