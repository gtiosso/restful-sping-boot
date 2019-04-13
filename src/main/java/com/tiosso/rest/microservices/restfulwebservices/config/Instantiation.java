package com.tiosso.rest.microservices.restfulwebservices.config;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.tiosso.rest.microservices.restfulwebservices.domain.User;
import com.tiosso.rest.microservices.restfulwebservices.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository repo;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		User u1 = new User(null, "Guilherme Tiosso", "guilherme.tiosso@gmail.com", sdf.parse("26/06/1992"));
		User u2 = new User(null, "Janaina Tiosso", "janaina.tiosso@gmail.com", sdf.parse("10/03/1989"));
		User u3 = new User(null, "Iara Tiosso", "iara.tiosso@gmail.com", sdf.parse("24/07/2010"));
		User u4 = new User(null, "Isabella Tiosso", "isabella.tiosso@gmail.com", sdf.parse("10/01/2018"));

		repo.addUser(u1);
		repo.addUser(u2);
		repo.addUser(u3);
		repo.addUser(u4);
	}
}
