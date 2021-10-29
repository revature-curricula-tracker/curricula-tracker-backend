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

import com.revature.model.Curriculum;
import com.revature.service.CurriculumService;

@RestController
@RequestMapping("/curriculum")
@CrossOrigin(origins = "http://curricula-tracker.s3-website-us-east-1.amazonaws.com/")
public class CurriculumController {

	@Autowired
	private CurriculumService cserv;

	@PostMapping("/add")
	public Curriculum insert(@Valid @RequestBody Curriculum c) {
		return cserv.insert(c);
	}

	// find all
	@GetMapping
	public List<Curriculum> findAll() {
		return cserv.findAll();
	}

	// find by name
	@GetMapping("/findId/{id}")
	public Curriculum findById(@PathVariable("id") int id) {
		return cserv.getById(id);
	}

	// find by name
	@GetMapping("/findName/{name}")
	public Curriculum findByName(@PathVariable("name") String name) {
		return cserv.getByCurriculumName(name);
	}

	// update by id
	@PostMapping("/update")
	public Curriculum updateById(@Valid @RequestBody Curriculum c) {
		return cserv.update(c);
	}

	// delete by id
	@DeleteMapping("/deleteById/{id}")
	public void removeCurriculumById(@PathVariable("id") int id) {
		
		
		cserv.removeById(id);
	}

}
