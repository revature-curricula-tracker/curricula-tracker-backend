package com.revature.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Technology;
import com.revature.service.TechnologyService;

@RestController
@RequestMapping("/tech")
@CrossOrigin(origins = "http://localhost:4200")
public class TechnologyController {

	@Autowired
	/*
	 * TechnologyService class autowired in for the controller to use its methods
	 */
	public TechnologyService techServ;

	@GetMapping("/{id}")
	/*
	 * controller that calls the getByTechId method
	 * @param id = unique id representing technology
	 * @return = Technology with id == id
	 */
	public Optional<Technology> findByTechId(@PathVariable ("id") int id) {
		return techServ.getById(id);
	}

	@GetMapping("/search/{name}")
	/*
	 * controller that calls the findByTechName method
	 * @param name = name of Technology being searched for
	 * @return = Technology with name == name
	 */
	public Optional<Technology> findByTechName(@PathVariable("name") String name) {
		return techServ.getByName(name);
	}

	@GetMapping
	/*
	 * controller that calls the findAll method
	 * @return = list containing all Technology in the repository
	 */
	public List<Technology> findAll() {
		return techServ.findAll();
	}

	@PostMapping("/add")
	/*
	 * controller that calls the insert method
	 * @param t = Technology being added to repository
	 * @return = Technology inserted into repository
	 */
	public Technology insert(@Valid @RequestBody Technology t) {
		return techServ.insertTechnology(t);
	}

	@PatchMapping("/{id}")
	/*
	 * controller that calls the update method
	 * @param t = Technology being updated
	 * @return = Technology being updated in repository
	 */
	public Technology update(@RequestBody Technology t) {
		return techServ.update(t);
	}

	@DeleteMapping("/{id}")
	/*
	 * controller that calls the delete method
	 * @param id = unique integer representing Technology to be deleted from repository
	 * @return = true or false depending upon whether Technology was deleted
	 */
	public Boolean delete(@PathVariable int id) {
		return techServ.deleteTechnology(id);
	}
}
