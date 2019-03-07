package com.greenslate.codechallenge.userproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenslate.codechallenge.userproject.entity.Project;
import com.greenslate.codechallenge.userproject.entity.User;
import com.greenslate.codechallenge.userproject.entity.UserProject;
import com.greenslate.codechallenge.userproject.repository.UserProjectRepository;

@Service
public class UserProjectService {
	@Autowired
	private UserProjectRepository userProjectRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
	public UserProject add(UserProject userProject) {
		return  userProjectRepository.save(userProject);
		
		/* it should work by only saving the user project
		
		userService.save(userProject.getUser());
		projectService.save(userProject.getProject());*/
	}
	
	public List<UserProject> findByProject(Project project){
		return userProjectRepository.findByProject(project);
	}
	public List<UserProject> findByUser(User user){
		return userProjectRepository.findByUser(user);
	}
}
