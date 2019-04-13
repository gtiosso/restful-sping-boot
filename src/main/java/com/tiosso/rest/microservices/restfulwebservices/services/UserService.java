package com.tiosso.rest.microservices.restfulwebservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiosso.rest.microservices.restfulwebservices.domain.User;
import com.tiosso.rest.microservices.restfulwebservices.repository.UserRepository;
import com.tiosso.rest.microservices.restfulwebservices.services.exceptions.ObjectNotFoundException;

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
		User obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("ERRO: Object Not Found - ID: " + id);
		}
		return obj;
	}
	
	public void updateUser(User obj) {
		repo.updateUser(obj);
	}
	
	public void removeUser(Integer id) {
		repo.removeUser(id);
	}
	
}
