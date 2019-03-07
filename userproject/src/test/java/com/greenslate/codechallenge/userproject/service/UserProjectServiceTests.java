package com.greenslate.codechallenge.userproject.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.greenslate.codechallenge.userproject.entity.Project;
import com.greenslate.codechallenge.userproject.entity.User;
import com.greenslate.codechallenge.userproject.entity.UserProject;
import com.greenslate.codechallenge.userproject.repository.ProjectRepository;
import com.greenslate.codechallenge.userproject.repository.UserProjectRepository;
import com.greenslate.codechallenge.userproject.repository.UserRepository;

@RunWith(SpringRunner.class)
public class UserProjectServiceTests {
	@MockBean
	private UserProjectRepository userProjectRepository;
	@MockBean
	private UserRepository userRepository;
	@MockBean
	private ProjectRepository projectRepository;
	@InjectMocks
	private UserProjectService userProjectService = new JpaUserProjectServiceImpl();
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		Project project1 = new Project(format.parse("2019-02-01"), format.parse("2019-04-10"),2);
		Project project2 = new Project(format.parse("2018-12-01"), format.parse("2019-06-10"),8);
		project1.setId(Long.valueOf(1));
		project2.setId(Long.valueOf(2));
		List<Project> projects = new LinkedList<>();
		projects.add(project1);
		projects.add(project2);
		
		User user1 = new User("Dan", "Smith");
		User user2 = new User("Marcus", "Garvey");
		user1.setId(Long.valueOf(1));
		user2.setId(Long.valueOf(2));
		List<User> userList = new LinkedList<>();
		userList.add(user1);
		userList.add(user2);
		
		UserProject userProject1 = new UserProject(user1,project1,true,format.parse("2019-02-01"));
		UserProject userProject2 = new UserProject(user1,project2,false,format.parse("2019-12-01"));
		
		List<UserProject> user1Projects = new LinkedList<>();
		List<UserProject> project1Users = new LinkedList<>();
		List<UserProject> project2Users = new LinkedList<>();
		user1Projects.add(userProject1);
		user1Projects.add(userProject2);
		project1Users.add(userProject1);
		
		Mockito.when(userRepository.findAll()).thenReturn(userList);
		Mockito.when(userRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(user1));
		Mockito.when(userRepository.findById(Long.valueOf(2))).thenReturn(Optional.of(user2));
		Mockito.when(projectRepository.findAll()).thenReturn(projects);
		Mockito.when(projectRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(project1));
		Mockito.when(projectRepository.findById(Long.valueOf(2))).thenReturn(Optional.of(project2));
		Mockito.when(userProjectRepository.findByUser(user1)).thenReturn(user1Projects);
		Mockito.when(userProjectRepository.findByProject(project1)).thenReturn(project1Users);
		Mockito.when(userProjectRepository.findByProject(project2)).thenReturn(project2Users);
		
	}
	
	
	@Test
	public void whenFindByUser_thenReturnList() {
		
		//given
		int expectedListSize = 2;
		User  user1 = new User("Dan", "Smith");
		user1.setId(Long.valueOf(1));
		//when
		List<UserProject> result = userProjectService.findByUser(user1);
		//then
		assertThat(result).size().isEqualTo(expectedListSize);
	}
	
	@Test
	public void whenFindByProject_thenReturnList() throws ParseException {
		
		//given
		int expectedListSize = 1;
		Project project1 = new Project(format.parse("2019-02-01"), format.parse("2019-04-10"),2);
		project1.setId(Long.valueOf(1));
		//when
		List<UserProject> result = userProjectService.findByProject(project1);
		//then
		assertThat(result).size().isEqualTo(expectedListSize);
	}
	
	@Test
	public void whenFindByUserThatHasNoProjects_thenReturnEmptyList() throws ParseException {
		
		//given
		int expectedListSize = 0;
		User  user2 = new User("Marcus", "Garvey");
		user2.setId(Long.valueOf(2));
		//when
		List<UserProject> result = userProjectService.findByUser(user2);
		//then
		assertThat(result).size().isEqualTo(expectedListSize);
	}
	
	@Test
	public void whenFindByProjectThatHasNoUsersAssigned_thenReturnEmptyList() throws ParseException {
		//setup
		Project project = new Project();
		project.setId(Long.valueOf(4));
		Mockito.when(userProjectRepository.findByProject(project)).thenReturn(new LinkedList<UserProject>());
		//given
		int expectedListSize = 0;
		//when
		List<UserProject> result = userProjectService.findByProject(project);
		//then
		assertThat(result).size().isEqualTo(expectedListSize);
	}

	
	@Test
	public void whenFindByUserThatDoesntExists_thenReturnEmptyList() throws ParseException {
		
		//given
		int expectedListSize = 0;
		User  user2 = new User();
		user2.setId(Long.valueOf(4));
		//when
		List<UserProject> result = userProjectService.findByUser(user2);
		//then
		assertThat(result).size().isEqualTo(expectedListSize);
	}

}
