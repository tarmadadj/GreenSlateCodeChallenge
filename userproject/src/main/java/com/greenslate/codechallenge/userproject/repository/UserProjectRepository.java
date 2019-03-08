package com.greenslate.codechallenge.userproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenslate.codechallenge.userproject.entity.Project;
import com.greenslate.codechallenge.userproject.entity.User;
import com.greenslate.codechallenge.userproject.entity.UserProject;
/**
 * Repository in charge of persisting UserProject objects, there are no methods implemented because this is an interface which extends
 * JpaRepository<Object, Key>. I use the named query standard to specify that i want to find UserProjects by user and by project.
 * Spring Data actually implements this class in order to create Proxy classes which handle the Database Requests
 * The Repository annotation tells spring that this is a Bean in charge of obtaining data
 * @author Mario Segura
 *
 */
@Repository
public interface UserProjectRepository extends JpaRepository<UserProject, Long>{
	public List<UserProject> findByUser(User user);
	public List<UserProject> findByProject(Project project);
}
