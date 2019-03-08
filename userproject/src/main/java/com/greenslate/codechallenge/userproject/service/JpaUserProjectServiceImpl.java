package com.greenslate.codechallenge.userproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenslate.codechallenge.userproject.entity.Project;
import com.greenslate.codechallenge.userproject.entity.User;
import com.greenslate.codechallenge.userproject.entity.UserProject;
import com.greenslate.codechallenge.userproject.repository.UserProjectRepository;
/**
 * Service which is in charge of performing tasks related to the UserProject entity
 * The Service annotation marks this class as a Service in a MVC pattern which will handle most of the business logic 
 * related to UserProject Entities
 * The Controllers don't actually reference this class as we want to avoid tight coupling, so this is an implementation which
 * is designed around JPA/Hibernate. We could  replace this class with a MongoDB implementation or a file system, Queue REST consumer 
 * or whatever may be needed in the future.
 * I also use this service as a method to expose only the Repository methods needed for this problem
 * 
 * @author Mario Segura
 *
 */

@Service
public class JpaUserProjectServiceImpl implements UserProjectService {
	@Autowired
	private UserProjectRepository userProjectRepository;
	
	/* (non-Javadoc)
	 * @see com.greenslate.codechallenge.userproject.service.UserProjectService#add(com.greenslate.codechallenge.userproject.entity.UserProject)
	 */
	@Override
	public UserProject save(UserProject userProject) {
		return  userProjectRepository.save(userProject);
		
	}
	
	/* (non-Javadoc)
	 * @see com.greenslate.codechallenge.userproject.service.UserProjectService#findByProject(com.greenslate.codechallenge.userproject.entity.Project)
	 */
	@Override
	public List<UserProject> findByProject(Project project){
		return userProjectRepository.findByProject(project);
	}
	/* (non-Javadoc)
	 * @see com.greenslate.codechallenge.userproject.service.UserProjectService#findByUser(com.greenslate.codechallenge.userproject.entity.User)
	 */
	@Override
	public List<UserProject> findByUser(User user){
		return userProjectRepository.findByUser(user);
	}
}
