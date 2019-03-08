package com.greenslate.codechallenge.userproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenslate.codechallenge.userproject.entity.Project;
import com.greenslate.codechallenge.userproject.exception.ProjectNotFoundException;
import com.greenslate.codechallenge.userproject.repository.ProjectRepository;
/**
 * Service which is in charge of performing tasks related to the Project entiry
 * The Service annotation marks this class as a Service in a MVC pattern which will handle most of the business logic 
 * related to Project Entities
 * The Controller doesn't actually reference this class as we want to avoid tight coupling, so this is an implementation which
 * is designed around JPA/Hibernate. We could  replace this class with a MongoDB implementation or a file system, Queue REST consumer 
 * or whatever may be needed in the future.
 * I also use this service as a method to expose only the Repository methods needed for this problem
 * 
 * @author Mario Segura
 *
 */

@Service
public class JpaProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	
	/** 
	 * 
	 * @see com.greenslate.codechallenge.userproject.service.ProjectService#findAll()
	 */
	@Override
	public List<Project> findAll(){
		return projectRepository.findAll();
	}
	
	/**
	 * We use Optional provided by the Repository in order to tell if raise an exception, a user shouldn't be querying for non
	 * existing users so i think this is a good chance to use Exceptions in order to handle unexpected behavior
	 * As a limitation i think i could handle better situations like negative Ids 
	 * @see com.greenslate.codechallenge.userproject.service.ProjectService#findById(java.lang.Long)
	 */
	@Override
	public Project findById(Long id) throws ProjectNotFoundException {
		Optional<Project> projectOptional = projectRepository.findById(id);
		if(projectOptional.isPresent()) {
			return projectOptional.get();
		}else {
			throw new ProjectNotFoundException();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.greenslate.codechallenge.userproject.service.ProjectService#save(com.greenslate.codechallenge.userproject.entity.Project)
	 */
	@Override
	public Project save(Project project) {
		return projectRepository.save(project);
	}

}
