/*package com.springboot.rest.FirstRestApplication.jpa;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

import com.springboot.rest.FirstRestApplication.model.User;

@Component
public class CommandLine implements CommandLineRunner {

	@Autowired
	UserRepository repository;

	@Override
	public void run(String... args) throws Exception {
	*/	
		/* Comment
		After spring boot application launches,the first thing that executes is
		within the CommandLineRunner run method.
		System.out.println("Argument length:" + args.length);
		System.out.println("First Task after spring boot application launch");
		*/
/*
		repository.save(new User("Pranjali", "Software Engineer"));
		repository.save(new User("Mayur", "Mechanical Engineer"));
		repository.save(new User("Sanjay", "TATA Motors"));
		repository.save(new User("Rajashree", "HomeMaker"));
		repository.save(new User("Ashwini", "HomeMaker"));
		repository.save(new User("Aishwarya", "HomeMaker"));*/

		/* Comment
		 * System.out.println("First Task after spring boot application launch");
		 * System.out.println(repository.save(new User("Pranjali",
		 * "Software Engineer"))); System.out.println(repository.save(new User("Mayur",
		 * "Mechanical Engineer"))); System.out.println(repository.save(new
		 * User("Sanjay", "TATA Motors"))); System.out.println(repository.save(new
		 * User("Rajashree", "HomeMaker")));
		 */

/*
		System.out.println("Count:" + repository.count());
		Optional<User> u = repository.findById((long) 5);
		System.out.println("Result of findById:" + u);

		System.out.println(repository.existsById((long) 10));

		repository.deleteById((long) 1);
		for (User temp : repository.findAll()) {
			System.out.println(temp);
		}
		
		System.out.println("Query Method,findByName");
		User u1=repository.findByName("Rajashree");
		System.out.println("u1:"+u1);
		
		
		
		System.out.println("Query Method,findByRole");
		User u2=repository.findByRole("Mechanical Engineer");
		System.out.println("u2:"+u2);
		
		
		System.out.println("Query Method,findFirst2ByRole");
		List<User> u3=repository.findFirst2ByRole("HomeMaker");
		System.out.println("u3:"+u3);
		
		System.out.println("Query Method,findTop3ByRole");
		List<User> u4=repository.findTop3ByRole("HomeMaker");
		System.out.println("u4:"+u4);
		
		
		


	}


}

*/