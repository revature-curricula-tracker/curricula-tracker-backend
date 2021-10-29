package com.revature.model.json;

import com.revature.model.Technology;
import com.revature.model.Topic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurriculumTopicJson {
	
	public CurriculumTopicJson(final Topic top) {
		this.id = top.getId();
		this.name = top.getName();
		this.description = top.getDescription();
		this.technology = top.getTechnology();
	}
	
	public CurriculumTopicJson(final Topic top, final int topicDay) {
		this.id = top.getId();
		this.name = top.getName();
		this.description = top.getDescription();
		this.technology = top.getTechnology();
		this.topicDay = topicDay;
	}
	
	private int id;
	private String name;
	private String description;
	private Technology technology;
	private int topicDay;

}
