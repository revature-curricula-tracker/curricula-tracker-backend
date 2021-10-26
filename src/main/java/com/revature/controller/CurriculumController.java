package com.revature.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@CrossOrigin(origins = "*")
public class CurriculumController {
	
	@Autowired
	private CurriculumService cserv;
	
		@PostMapping("/add")
		public ResponseEntity<Curriculum> insert(@Valid @RequestBody Curriculum c ) {
			return ResponseEntity.ok(cserv.insert(c));
		}
	
		// find all
		@GetMapping
		public ResponseEntity<List<Curriculum>> findAll() {
			return ResponseEntity.ok(cserv.findAll());
		}
		
		// find by name
		@GetMapping("/findId/{id}")
		public ResponseEntity<Curriculum> findById(@PathVariable("id") int id) {
			return ResponseEntity.ok(cserv.getById(id));
		}
		
		// find by name
		@GetMapping("/findName/{name}")
		public ResponseEntity<Curriculum> findByName(@PathVariable("name") String name) {
			return ResponseEntity.ok(cserv.getByCurriculumName(name));
		}
		
		// update by id
		@PostMapping("/update")
		public ResponseEntity<Curriculum> updateById(@Valid @RequestBody Curriculum c ) {
			return ResponseEntity.ok(cserv.update(c));
		}
		
		//delete by id
		@DeleteMapping("/deleteById/{id}")
		public void removeCurriculumById(@PathVariable("id") int id) {
			cserv.removeById(id);
		}

}
