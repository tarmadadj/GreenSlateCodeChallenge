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

@RestController
@RequestMapping("api/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired UserProjectService userProjectService;
	
	@GetMapping("/")
	public List<User> findAll() {
		return userService.findAll();
				
	}
	
	@GetMapping("/{id}")
	public User findOne(@PathVariable Long id) {
		try {
			return userService.findById(id);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "User Not Found", e);
		}
				
	}
	
	@PostMapping("/")
	public User save(UserSaveRequest request) {
		User userToSave = new User(request.getFirstName(), request.getLastName());
		return userService.save(userToSave);
	}
	
	
	@GetMapping("/{id}/projects/")
	public List<UserProject> findProjectsForUser(@PathVariable Long id){
		User user = findOne(id);
		return userProjectService.findByUser(user);
		
	}
	
}
