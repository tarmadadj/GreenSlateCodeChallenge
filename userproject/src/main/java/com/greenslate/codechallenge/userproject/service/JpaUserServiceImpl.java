package com.greenslate.codechallenge.userproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenslate.codechallenge.userproject.entity.User;
import com.greenslate.codechallenge.userproject.exception.UserNotFoundException;
import com.greenslate.codechallenge.userproject.repository.UserRepository;

@Service
public class JpaUserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	/* (non-Javadoc)
	 * @see com.greenslate.codechallenge.userproject.service.UserService#findAll()
	 */
	@Override
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.greenslate.codechallenge.userproject.service.UserService#findById(java.lang.Long)
	 */
	@Override
	public User findById(Long id) throws UserNotFoundException {
		Optional<User> userOptional = userRepository.findById(id);
		if(userOptional.isPresent()) {
			return userOptional.get();
		}else {
			throw new UserNotFoundException();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.greenslate.codechallenge.userproject.service.UserService#save(com.greenslate.codechallenge.userproject.entity.User)
	 */
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}
}
