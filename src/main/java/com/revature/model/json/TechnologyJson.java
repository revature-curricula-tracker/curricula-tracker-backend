package com.revature.model.json;

import com.revature.model.Technology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TechnologyJson {
	
	public TechnologyJson(final Technology tech) {
		this.techId = tech.getTechId();
		this.techName = tech.getTechName();
		this.color = tech.getColor();
	}
	
	private int techId;
	private String techName;
	private String color;

}
