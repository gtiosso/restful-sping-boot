package com.tiosso.rest.microservices.restfulwebservices.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiosso.rest.microservices.restfulwebservices.domain.User;
import com.tiosso.rest.microservices.restfulwebservices.repository.UserRepository;
import com.tiosso.rest.microservices.restfulwebservices.services.exceptions.ConflictException;
import com.tiosso.rest.microservices.restfulwebservices.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	

	@Autowired
	private UserRepository repo;
	
	
	public void insert(User obj) {
		// Validando se email ja existe
		if(repo.findAll().stream().anyMatch(x -> x.getEmail().equals(obj.getEmail()))) { 
			throw new ConflictException("ERROR: Conflict  - Email already exist");
		}
		
		repo.insert(obj);
	}
	
	public Set<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(Integer id) {
		User obj = repo.findById(id);
		// Validando se usuario existe
		if (obj == null) {
			throw new ObjectNotFoundException("ERROR: Object Not Found - ID: " + id);
		}
		return obj;
	}
	
	public void update(User obj) {
		repo.update(obj);
	}
	
	public void delete(Integer id) {
		repo.delete(id);
	}
}
