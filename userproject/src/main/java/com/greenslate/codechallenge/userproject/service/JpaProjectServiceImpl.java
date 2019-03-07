package com.greenslate.codechallenge.userproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenslate.codechallenge.userproject.entity.Project;
import com.greenslate.codechallenge.userproject.exception.ProjectNotFoundException;
import com.greenslate.codechallenge.userproject.repository.ProjectRepository;
@Service
public class JpaProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	
	/* (non-Javadoc)
	 * @see com.greenslate.codechallenge.userproject.service.ProjectService#findAll()
	 */
	@Override
	public List<Project> findAll(){
		return projectRepository.findAll();
	}
	
	/* (non-Javadoc)
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
