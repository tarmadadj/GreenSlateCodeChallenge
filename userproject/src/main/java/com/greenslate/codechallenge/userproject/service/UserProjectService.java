package com.greenslate.codechallenge.userproject.service;

import java.util.List;

import com.greenslate.codechallenge.userproject.entity.Project;
import com.greenslate.codechallenge.userproject.entity.User;
import com.greenslate.codechallenge.userproject.entity.UserProject;

public interface UserProjectService {

	UserProject add(UserProject userProject);

	List<UserProject> findByProject(Project project);

	List<UserProject> findByUser(User user);

}