package com.greenslate.codechallenge.userproject.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.greenslate.codechallenge.userproject.exception.ProjectNotFoundException;
import com.greenslate.codechallenge.userproject.repository.ProjectRepository;
@RunWith(SpringRunner.class)
public class ProjectServiceTests {
	@MockBean
	private ProjectRepository projectRepository;
	@InjectMocks
	private ProjectService projectService = new JpaProjectServiceImpl();
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
		Mockito.when(projectRepository.findAll()).thenReturn(projects);
		
		Mockito.when(projectRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(project1));
		Mockito.when(projectRepository.findById(Long.valueOf(2))).thenReturn(Optional.of(project2));
	}
	
	@Test
	public void whenFindAll_thenReturnList() {
		//given
		int expectedListSize =2;
		//when
		List<Project> result = projectService.findAll();
		//then
		assertThat(result).size().isEqualTo(expectedListSize);
	}
	
	@Test
	public void whenThereAreNoProjects_thenReturnEmptyList() {
		// set up
		Mockito.when(projectService.findAll()).thenReturn(new LinkedList<Project>()); //mocks empty database beheavor
		//given
		int expectedListSize =0;
		//when
		List<Project> result = projectService.findAll();
		//then
		assertThat(result).size().isEqualTo(expectedListSize);
	}
	
	@Test
	public void whenFindOne_thenReturn() throws ParseException {
		//given
		Date  expectedFirstDate  = format.parse("2019-02-01");
		Long givenId=Long.valueOf(1);
		//when
		Project result;
		try {
			result = projectService.findById(givenId);
			//then
			assertThat(result.getStartDate()).isEqualTo(expectedFirstDate);
		} catch ( ProjectNotFoundException e) {
			fail("Search for a single valid projectId shouldn't cause a not found exception");
		}
	}
	
	@Test
	public void whenFindOneAndItDoesntExist_thenThrowException() {
		//setup
		Mockito.when(projectRepository.findById(Long.valueOf(3))).thenReturn(Optional.empty());
		//given
		Long givenId=Long.valueOf(3);
		//when
		
		try {
			projectService.findById(givenId);
			//then
			fail("Search for non existing user should throw an exception");
		} catch ( ProjectNotFoundException e) {
		}
	}
	
	
}
