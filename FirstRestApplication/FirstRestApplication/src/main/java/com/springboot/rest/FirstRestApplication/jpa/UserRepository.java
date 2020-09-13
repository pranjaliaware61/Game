package com.springboot.rest.FirstRestApplication.jpa;


import java.util.List;

import org.springframework.data.domain.Slice;
import org.springframework.data.repository.CrudRepository;

import com.springboot.rest.FirstRestApplication.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByName(String name);
	public User findByRole(String role);
	public List<User> findFirst2ByRole(String role);
	public List<User> findTop3ByRole(String role);

}
