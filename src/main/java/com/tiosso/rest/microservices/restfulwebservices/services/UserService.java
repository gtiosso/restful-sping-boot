package com.tiosso.rest.microservices.restfulwebservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiosso.rest.microservices.restfulwebservices.domain.User;
import com.tiosso.rest.microservices.restfulwebservices.repository.UserRepository;

@Service
public class UserService {
	

	@Autowired
	private UserRepository repo;
	
	
	public void addUser(User obj) {
		repo.addUser(obj);
	}
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(Integer id) {
		return repo.findById(id);
	}
	
}
