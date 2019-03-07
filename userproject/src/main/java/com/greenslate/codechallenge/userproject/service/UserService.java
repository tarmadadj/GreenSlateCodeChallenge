package com.greenslate.codechallenge.userproject.service;

import java.util.List;

import com.greenslate.codechallenge.userproject.entity.User;
import com.greenslate.codechallenge.userproject.exception.UserNotFoundException;

public interface UserService {

	List<User> findAll();

	User findById(Long id) throws UserNotFoundException;

	User save(User user);

}