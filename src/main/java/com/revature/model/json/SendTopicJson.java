package com.revature.model.json;

import com.revature.model.Curriculum;
import com.revature.model.Technology;
import com.revature.model.Topic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendTopicJson {
	
	public SendTopicJson(final Topic topic) {
		this.id = topic.getId();
		this.topicDay = topic.getTopicDay();
		this.name = topic.getName();
		this.description = topic.getDescription();
		this.technology = topic.getTechnology();
		this.curriculum = topic.getCurriculum();
	}

	private int id;
	private int topicDay;
	private String name;
	private String description;
	private Technology technology;
	private Curriculum curriculum;
}
