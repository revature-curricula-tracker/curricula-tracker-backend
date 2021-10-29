package com.revature.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.CurriculumTopic;
import com.revature.service.CurriculumTopicService;

@RestController
@RequestMapping("/curriculumTopic")
@CrossOrigin(origins = "http://localhost:4200")
public class CurriculumTopicController {

	@Autowired
	private CurriculumTopicService ctServ;
	
	@PostMapping("/add")
	public CurriculumTopic insert(@Valid @RequestBody CurriculumTopic c) {
		return ctServ.insert(c);
	}
	@PostMapping("/update")
	public CurriculumTopic update(@Valid @RequestBody CurriculumTopic c) {
		return ctServ.insert(c);
	}
	
	// find all
	@GetMapping
	public List<CurriculumTopic> findAll() {
		return ctServ.findAll();
	}
	
	//find by ID
	@GetMapping("/findByIds/{curriculumId}&{topicId}")
	public CurriculumTopic findCurriculumTopicByIds(@PathVariable("curriculumId") int curriculumId, @PathVariable("topicId") int topicId ) {
		return ctServ.findByIds(curriculumId, topicId);
	}
	// delete by id
	@DeleteMapping("/deleteByIds/{curriculumId}&{topicId}")
	public boolean removeCurriculumTopicByIds(@PathVariable("curriculumId") int curriculumId, @PathVariable("topicId") int topicId ) {
		return ctServ.removeByIds(curriculumId, topicId);
	}
	
	//find by Curriculum ID
	@GetMapping("/findById/{curriculumId}")
	public List<CurriculumTopic> findCurriculumTopicByCurriculumId(@PathVariable("curriculumId") int curriculumId) {
		return ctServ.findByCurriculumId(curriculumId);
	}
	
}
