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

import com.greenslate.codechallenge.userproject.entity.User;
import com.greenslate.codechallenge.userproject.entity.UserProject;
import com.greenslate.codechallenge.userproject.entity.UserSaveRequest;
import com.greenslate.codechallenge.userproject.exception.UserNotFoundException;
import com.greenslate.codechallenge.userproject.service.UserProjectService;
import com.greenslate.codechallenge.userproject.service.UserService;
/**
 * Rest Controller in charge of finding and saving users
 * RestController annotation marks it as a controller which wont return any views 
 * RequestMapping tells the server that this controller will serve requests asking for api/users path,
 * it also sets the controller to take requests and responses as Plain Old Objects instead of leaving the decoding to the programmer
 * @author Mario Segura
 *
 */
@RestController
@RequestMapping("api/users")
public class UserController {
	/*
	 * User service used to save and find Users
	 * Autowired annotation is for deploying an Inversion of Control pattern, at this point 
	 * the concern we have is what does projectService do in order to help this controller rather than how are we
	 * going to instance it.
	 * Please note that we are referencing an Interface so in the future we could swap the JPA implementation i used in this project
	 * for a Mongo, file or any other which implements the ProjectService Interface
	 */
	@Autowired
	private UserService userService;
	/**
	 * UserProjectService in in charge of finding projects belonging to the specified user
	 */
	@Autowired 
	private UserProjectService userProjectService;
	
	/**
	 * Find all Users saved in the repository
	 * @return List with all users saved, if repository is empty, returns an empty list
	 */
	@GetMapping("/")
	public List<User> findAll() {
		return userService.findAll();
				
	}
	/**
	 * Finds one user which matches the specified id, if there are not users found it raises an exception with
	 * a NOT FOUND code, usually 404
	 * @return a User if found or raises an exception if not found
	 * 
	 */
	@GetMapping("/{id}")
	public User findOne(@PathVariable Long id) {
		try {
			return userService.findById(id);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "User Not Found", e);
		}
				
	}
	/**
	 * Saves a user into the repository
	 * @param request is a proxy object which skips the id field, so this method only can be used to add new users 
	 * @return a saved user with its new id
	 */
	@PostMapping("/")
	public User save(UserSaveRequest request) {
		User userToSave = new User(request.getFirstName(), request.getLastName());
		return userService.save(userToSave);
	}
	/**
	 * Finds all the projects related to the specified user
	 * In this method i don't raise an exception explicitly because i call the findOne() method defined early which
	 * handles that logic
	 * @param id of the user need for the query, i could ask for an user object but 1. being a GET request supposed to be in the 
	 * url path, this is kind of cumbersome but more important 2. i can check first if the User in the request actually exists
	 * @return
	 */
	
	@GetMapping("/{id}/projects/")
	public List<UserProject> findProjectsForUser(@PathVariable Long id){
		User user = findOne(id);
		return userProjectService.findByUser(user);
		
	}
	
}
