package com.greenslate.codechallenge.userproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.greenslate.codechallenge.userproject.entity.Project;
import com.greenslate.codechallenge.userproject.exception.ProjectNotFoundException;
import com.greenslate.codechallenge.userproject.service.ProjectService;

@RestController
@RequestMapping("api/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/")
	public List<Project> findAllProjects(){
		return projectService.findAll();
	}
	
	@GetMapping("{id}")
	public Project findOne(@PathVariable Long id) {
		try {
			return projectService.findById(id);
		} catch (ProjectNotFoundException e) {
			throw new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "Project Not Found", e);
		}
	}
	
	@PostMapping("/")
	public Project save(Project project) {
		return projectService.save(project);
	}
}
