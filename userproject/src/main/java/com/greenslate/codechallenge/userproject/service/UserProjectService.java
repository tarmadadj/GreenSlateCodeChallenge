package com.greenslate.codechallenge.userproject.service;

import java.util.List;

import com.greenslate.codechallenge.userproject.entity.Project;
import com.greenslate.codechallenge.userproject.entity.User;
import com.greenslate.codechallenge.userproject.entity.UserProject;
/**
 * UserProjectService interface represents which methods are needed to fulfill the application requirements on UserProjectService objects, also once the interface
 * is defined we could work on the controller and the service implementation at the same time as both only need to agree
 * in what methods are to be used, also return values and parameters
 * @author Mario Segura
 *
 */
public interface UserProjectService {

	public UserProject save(UserProject userProject);

	public List<UserProject> findByProject(Project project);

	public List<UserProject> findByUser(User user);

}