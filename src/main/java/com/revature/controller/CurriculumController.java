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
@CrossOrigin(origins = "http://localhost:4200")
public class CurriculumController {

	@Autowired
	private CurriculumService cserv;

	@PostMapping("/add")
	public Curriculum insert(@Valid @RequestBody final Curriculum c) {
		System.out.println("\n\ntest\n\n");
		return this.cserv.insert(c);
	}

	// find all
	@GetMapping
	public List<Curriculum> findAll() {
		return this.cserv.findAll();
	}

	// find by name
	@GetMapping("/findId/{id}")
	public Curriculum findById(@PathVariable("id") final int id) {
		return this.cserv.getById(id);
	}

	// find by name
	@GetMapping("/findName/{name}")
	public Curriculum findByName(@PathVariable("name") final String name) {
		return this.cserv.getByCurriculumName(name);
	}

	// update by id
	@PostMapping("/update")
	public Curriculum updateById(@Valid @RequestBody final Curriculum c) {
		return this.cserv.update(c);
	}

	// delete by id
	@DeleteMapping("/deleteById/{id}")
	public void removeCurriculumById(@PathVariable("id") final int id) {
		
		
		this.cserv.removeById(id);
	}

}
