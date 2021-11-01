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

import com.revature.advice.CorsFilter;
import com.revature.model.Technology;
import com.revature.service.TechnologyService;

@RestController
@RequestMapping("/tech")
@CrossOrigin(origins = {CorsFilter.ORIGIN,CorsFilter.LOCALHOST})
public class TechnologyController {

	@Autowired
	public TechnologyService techServ;

	@GetMapping("/{id}")
	public Optional<Technology> findByTechId(@PathVariable ("id") final int id) {
		return techServ.getById(id);
	}

	@GetMapping("/search/{name}")
	public Optional<Technology> findByTechName(@PathVariable("name") final String name) {
		return techServ.getByName(name);
	}

	@GetMapping
	public List<Technology> findAll() {
		return techServ.findAll();
	}

	@PostMapping("/add")
	public Technology insert(@Valid @RequestBody final Technology t) {
		return techServ.insertTechnology(t);
	}

	@PatchMapping("/{id}")
	public Technology update(@RequestBody final Technology t) {
		return techServ.update(t);
	}

	@DeleteMapping("/{id}")
	public Boolean delete(@PathVariable final int id) {
		return techServ.deleteTechnology(id);
	}
}
