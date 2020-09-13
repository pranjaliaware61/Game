package com.springboot.rest.FirstRestApplication.datarest;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.rest.FirstRestApplication.model.User;

@RepositoryRestResource(collectionResourceRel = "sanny",path="sanny")
public interface RestRepository  extends PagingAndSortingRepository<User, Long>
{
	public User findByName(@Param("name") String name);
	public List<User> findFirst2ByRole(@Param("role") String role);
}
