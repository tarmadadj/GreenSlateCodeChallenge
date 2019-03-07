package com.greenslate.codechallenge.userproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenslate.codechallenge.userproject.entity.User;
import com.greenslate.codechallenge.userproject.exception.UserNotFoundException;
import com.greenslate.codechallenge.userproject.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) throws UserNotFoundException {
		Optional<User> userOptional = userRepository.findById(id);
		if(userOptional.isPresent()) {
			return userOptional.get();
		}else {
			throw new UserNotFoundException();
		}
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
}
