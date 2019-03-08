package com.greenslate.codechallenge.userproject.service;

import java.util.List;

import com.greenslate.codechallenge.userproject.entity.User;
import com.greenslate.codechallenge.userproject.exception.UserNotFoundException;
/**
 * User UserService interface represents which methods are needed to fulfill the application requirements on Users, also once the interface
 * is defined we could work on the controller and the service implementation at the same time as both only need to agree
 * in what methods are to be used, also return values and parameters
 * @author Mario Segura
 *
 */
public interface UserService {

	public List<User> findAll();

	public User findById(Long id) throws UserNotFoundException;

	public User save(User user);

}