package com.revature.controller;

import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Curriculum;
import com.revature.model.CurriculumTopic;
import com.revature.model.Topic;
import com.revature.service.CurriculumTopicService;

@RestController
@RequestMapping("/curriculumTopic")
@CrossOrigin(origins = "*")
public class CurriculumTopicController {
	
	@Autowired
	private CurriculumTopicService curriculumTopicService;
	
	@GetMapping("/findAll")
	public ResponseEntity<Set<CurriculumTopic>> findAll() {
		return ResponseEntity.ok(curriculumTopicService.findAll());
	}
	
	@GetMapping("/curriculumId/{curriculumId}")
	public ResponseEntity<Optional<Set<CurriculumTopic>>> getAllByCurriculumId(Curriculum curriculum) {
		return ResponseEntity.ok(curriculumTopicService.getAllByCurriculum(curriculum));
	}
	
	@GetMapping("/topicId/{topicId}")
	public ResponseEntity<Optional<Set<CurriculumTopic>>> getAllByTopicId(Topic topic) {
		return ResponseEntity.ok(curriculumTopicService.getAllByTopic(topic));
	}
	
	@PostMapping("/add")
	public ResponseEntity<CurriculumTopic> insert(@Valid @RequestBody CurriculumTopic ct) {

		return ResponseEntity.ok(curriculumTopicService.insertCurriculumTopic(ct));
	} 
	

}
