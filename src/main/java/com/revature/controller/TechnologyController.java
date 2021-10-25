package com.revature.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Technology;
import com.revature.service.TechnologyService;

@RestController
@RequestMapping("/tech")
public class TechnologyController {
	
	@Autowired
	public TechnologyService techServ;
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Technology>> findByTechId(@RequestParam("id") int id){
		return ResponseEntity.ok(techServ.getById(id));
	}
	
	@GetMapping("/search/{name}")
	public ResponseEntity<Optional<Technology>> findByTechName(@RequestParam("Name") String name){
		return ResponseEntity.ok(techServ.getByName(name));
	}
	
	@GetMapping
	public ResponseEntity<List<Technology>> findAll(){
		return ResponseEntity.ok(techServ.findAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<Technology> insert(@RequestBody Technology t){
		return ResponseEntity.ok(techServ.insertTechnology(t));
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Technology> update(@RequestBody Technology t){
		return ResponseEntity.ok(techServ.update(t));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable int id){
		return ResponseEntity.ok(techServ.deleteTechnology(id));
	}
}
