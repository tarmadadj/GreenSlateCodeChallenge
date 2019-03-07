package com.greenslate.codechallenge.userproject.service;

import java.util.List;

import com.greenslate.codechallenge.userproject.entity.Project;
import com.greenslate.codechallenge.userproject.exception.ProjectNotFoundException;

public interface ProjectService {

	List<Project> findAll();

	Project findById(Long id) throws ProjectNotFoundException;

	Project save(Project project);

}