package com.greenslate.codechallenge.userproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenslate.codechallenge.userproject.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

}
