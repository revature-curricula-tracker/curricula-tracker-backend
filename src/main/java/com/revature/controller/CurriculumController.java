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
	/*
	 * CuriculumService class autowired in to use its methods
	 */
	private CurriculumService cserv;

	@PostMapping("/add")
	/*
	 * controller that calls the insert method
	 * @param c = input Curriculum
	 * @return = inserted Curriculum
	 */
	public Curriculum insert(@Valid @RequestBody Curriculum c) {
		return cserv.insert(c);
	}

	/*
	 * finds all Curriculum in repository
	 * @return = list of all Curriculum
	 */
	@GetMapping
	public List<Curriculum> findAll() {
		return cserv.findAll();
	}

	/*
	 * finds a Curriculum based on input id
	 * @param id = unique integer representing specific Curriculum
	 * @return = Curriculum with id == id
	 */
	@GetMapping("/findId/{id}")
	public Curriculum findById(@PathVariable("id") int id) {
		return cserv.getById(id);
	}

	/*
	 * finds a Curriculum based on input name
	 * @param name = String that is the name of Curriculum being searched for
	 * @return = Curriculum with name == name
	 */
	@GetMapping("/findName/{name}")
	public Curriculum findByName(@PathVariable("name") String name) {
		return cserv.getByCurriculumName(name);
	}

	/*
	 * updates input Curriculum in repository
	 * @param c = Curriculum being updated
	 * @return = The Curriculum being updated
	 */
	@PostMapping("/update")
	public Curriculum updateById(@Valid @RequestBody Curriculum c) {
		return cserv.update(c);
	}

	/*
	 * deletes Curriculum from repository with input id
	 * @param id = unique integer of Curriculum being removed
	 */
	@DeleteMapping("/deleteById/{id}")
	public void removeCurriculumById(@PathVariable("id") int id) {
		cserv.removeById(id);
	}

}
