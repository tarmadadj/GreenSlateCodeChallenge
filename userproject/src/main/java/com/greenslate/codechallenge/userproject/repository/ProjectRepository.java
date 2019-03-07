package com.greenslate.codechallenge.userproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenslate.codechallenge.userproject.entity.Project;

@Repository
public interface ProjectRepository  extends JpaRepository<Project, Long>{

}
