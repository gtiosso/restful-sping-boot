package com.tiosso.rest.microservices.restfulwebservices.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiosso.rest.microservices.restfulwebservices.domain.Post;
import com.tiosso.rest.microservices.restfulwebservices.domain.User;
import com.tiosso.rest.microservices.restfulwebservices.repository.UserRepository;
import com.tiosso.rest.microservices.restfulwebservices.services.exceptions.BadRequestException;
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
		// Validando se campos estão nulos
		if (obj.getName() == null) {
			throw new BadRequestException("ERROR: Bad Request  - Field name is null");
		}
		if (obj.getEmail() == null) {
			throw new BadRequestException("ERROR: Bad Request  - Field email is null");
		}
		if (obj.getBirthDate() == null) {
			throw new BadRequestException("ERROR: Bad Request  - Field birthDate is null");
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
	
	public void updateUserPost(User obj, Post post) {
		repo.updateUserPost(obj, post);
	}
}
