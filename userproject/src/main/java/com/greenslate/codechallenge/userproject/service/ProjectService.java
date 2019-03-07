package com.greenslate.codechallenge.userproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenslate.codechallenge.userproject.entity.Project;
import com.greenslate.codechallenge.userproject.exception.ProjectNotFoundException;
import com.greenslate.codechallenge.userproject.repository.ProjectRepository;
@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	
	public List<Project> findAll(){
		return projectRepository.findAll();
	}
	
	public Project findById(Long id) throws ProjectNotFoundException {
		Optional<Project> projectOptional = projectRepository.findById(id);
		if(projectOptional.isPresent()) {
			return projectOptional.get();
		}else {
			throw new ProjectNotFoundException();
		}
	}
	
	public Project save(Project project) {
		return projectRepository.save(project);
	}

}
