package com.greenslate.codechallenge.userproject.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

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

import com.greenslate.codechallenge.userproject.entity.User;
import com.greenslate.codechallenge.userproject.exception.UserNotFoundException;
import com.greenslate.codechallenge.userproject.repository.UserRepository;
@RunWith(SpringRunner.class)
public class UserServiceTests {
	@MockBean
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService = new JpaUserServiceImpl();
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		User user1 = new User("Dan", "Smith");
		User user2 = new User("Marcus", "Garvey");
		user1.setId(Long.valueOf(1));
		user2.setId(Long.valueOf(2));
		List<User> userList = new LinkedList<>();
		userList.add(user1);
		userList.add(user2);
		Mockito.when(userRepository.findAll()).thenReturn(userList);
		Mockito.when(userRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(user1));
		Mockito.when(userRepository.findById(Long.valueOf(2))).thenReturn(Optional.of(user2));
	}

	@Test
	public void whenFindAll_thenReturnList() {
		
		//given
		int expectedListSize =2;
		//when
		List<User> result = userService.findAll();
		//then
		assertThat(result).size().isEqualTo(expectedListSize);
	}
	
	@Test
	public void whenThereAreNoUsers_thenReturnEmptyList() {
		// set up
		Mockito.when(userRepository.findAll()).thenReturn(new LinkedList<User>()); //mocks empty database beheavor
		//given
		int expectedListSize =0;
		//when
		List<User> result = userService.findAll();
		//then
		assertThat(result).size().isEqualTo(expectedListSize);
	}
	
	@Test
	public void whenFindOne_thenReturn() {
	
		//given
		String  expectedUser1Name  ="Dan";
		Long givenId=Long.valueOf(1);
		//when
		User result;
		try {
			result = userService.findById(givenId);
			//then
			assertThat(result.getFirstName()).isEqualTo(expectedUser1Name);
		} catch (UserNotFoundException e) {

			fail("Search for a single valid userId shouldn't cause a not found exception");
		}
	}
	
	@Test
	public void whenFindOneAndItDoesntExist_thenThrowException() {
		//setup
		Mockito.when(userRepository.findById(Long.valueOf(3))).thenReturn(Optional.empty());
		//given
		Long givenId=Long.valueOf(3);
		//when
		
		try {
			userService.findById(givenId);
			//then
			fail("Search for non existing user should throw an exception");
		} catch (UserNotFoundException e) {
		}
	}

}
