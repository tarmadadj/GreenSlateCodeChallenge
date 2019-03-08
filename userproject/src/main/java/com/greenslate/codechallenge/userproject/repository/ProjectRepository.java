package com.greenslate.codechallenge.userproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenslate.codechallenge.userproject.entity.Project;
/**
 * Repository in charge of persisting Projects, there are no methods named because this is an interface which extends
 * JpaRepository<Object, Key>. This exercise doesn't require any custom queries so i use the default ones provided.
 * Spring Data actually implements this class in order to create Proxy classes which handle the Database Requests
 * The Repository annotation tells spring that this is a Bean in charge of obtaining data
 * @author Mario Segura
 *
 */
@Repository
public interface ProjectRepository  extends JpaRepository<Project, Long>{

}
