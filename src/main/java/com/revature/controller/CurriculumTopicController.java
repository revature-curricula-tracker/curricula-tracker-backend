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
}
