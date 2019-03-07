package com.greenslate.codechallenge.userproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenslate.codechallenge.userproject.entity.Project;
import com.greenslate.codechallenge.userproject.entity.User;
import com.greenslate.codechallenge.userproject.entity.UserProject;
import com.greenslate.codechallenge.userproject.repository.UserProjectRepository;

@Service
public class JpaUserProjectServiceImpl implements UserProjectService {
	@Autowired
	private UserProjectRepository userProjectRepository;
	
	/* (non-Javadoc)
	 * @see com.greenslate.codechallenge.userproject.service.UserProjectService#add(com.greenslate.codechallenge.userproject.entity.UserProject)
	 */
	@Override
	public UserProject add(UserProject userProject) {
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
