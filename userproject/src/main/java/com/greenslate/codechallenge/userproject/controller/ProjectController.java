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
/**
 * Gives REST methods in order to find and save Projects
 * RestController annotation marks it as a controller which wont return any views 
 * RequestMapping tells the server that this controller will serve requests asking for api/projects path,
 * it also sets the controller to take requests and responses as Plain Old Objects instead of leaving the decoding to the programmer
 * @author Mario Segura
 *
 */
@RestController
@RequestMapping("api/projects")
public class ProjectController {

	/**
	 * Project service is in charge of finding and saving projects
	 * Autowired annotation is for deploying an Inversion of Control pattern, at this point 
	 * the concern we have is what does projectService do in order to help this controller rather than how are we
	 * going to instance it.
	 * Please note that we are referencing an Interface so in the future we could swap the JPA implementation i used in this project
	 * for a Mongo, file or any other which implements the ProjectService Interface
	 */
	@Autowired
	private ProjectService projectService;
	
	/**
	 * Finds all projects currently saved in the repository
	 * GetMapping annotation sets the controller in order  to receive GET requests addressed as api/projects/ 
	 * and process them with this method.
	 * 
	 * @return a list with all the projects saved in the repository
	 */
	@GetMapping("/")
	public List<Project> findAllProjects(){
		return projectService.findAll();
	}
	/**
	 * Tries to find a Project with the given id, if not found, projectService will raise an exception, this controller handles it
	 * by converting it to an Spring standard ResponseStatusException, by doing this the server will return a status code and message
	 * telling the user about the problem
	 * @param id of a possible project
	 * @return a project that will match the specified id or an exception telling the user that the project couldn't be found
	 */
	@GetMapping("/{id}")
	public Project findOne(@PathVariable Long id) {
		try {
			return projectService.findById(id);
		} catch (ProjectNotFoundException e) {
			throw new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "Project Not Found", e);
		}
	}
	/**
	 * Saves a project into the repository, if it already exists updates the managed instance with new data
	 * 
	 * @param project to save or update
	 * @return updated project
	 */
	@PostMapping("/")
	public Project save(Project project) {
		return projectService.save(project);
	}
}
