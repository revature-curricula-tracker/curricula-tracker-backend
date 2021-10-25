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
@RequestMapping("/technology")
public class TechnologyController {
	
	@Autowired
	public TechnologyService techServ;
	
	@GetMapping("/findById")
	public ResponseEntity<Optional<Technology>> findById(@RequestParam("id") int id){
		return ResponseEntity.ok(techServ.getById(id));
	}
	
	@GetMapping("/findByUsername")
	public ResponseEntity<Optional<Technology>> findByUsername(@RequestParam("username") String username){
		return ResponseEntity.ok(techServ.getByName(username));
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Technology>> findAll(){
		return ResponseEntity.ok(techServ.findAll());
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Technology> insert(@RequestBody Technology t){
		return ResponseEntity.ok(techServ.insertTechnology(t));
	}
	
	@PatchMapping("/update")
	public ResponseEntity<Technology> update(@RequestBody Technology t){
		return ResponseEntity.ok(techServ.update(t));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Void> delete(@PathVariable int id){
		techServ.deleteTechnology(id);
		return ResponseEntity.noContent().build();
	}
}
