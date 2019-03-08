package com.greenslate.codechallenge.userproject.service;

import java.util.List;

import com.greenslate.codechallenge.userproject.entity.Project;
import com.greenslate.codechallenge.userproject.exception.ProjectNotFoundException;
/**
 * Project Service interface represents which methods are needed to fulfill the application requirements, also once the interface
 * is defined we could work on the controller and the service implementation at the same time as both only need to agree
 * in what methods are to be used, also return values and parameters
 * @author Mario Segura
 *
 */
public interface ProjectService {

	public List<Project> findAll();

	public Project findById(Long id) throws ProjectNotFoundException;

	public Project save(Project project);

}