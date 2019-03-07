package com.greenslate.codechallenge.userproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenslate.codechallenge.userproject.entity.Project;
import com.greenslate.codechallenge.userproject.entity.User;
import com.greenslate.codechallenge.userproject.entity.UserProject;

@Repository
public interface UserProjectRepository extends JpaRepository<UserProject, Long>{
	public List<UserProject> findByUser(User user);
	public List<UserProject> findByProject(Project project);
}
