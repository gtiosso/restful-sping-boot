package com.tiosso.rest.microservices.restfulwebservices.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tiosso.rest.microservices.restfulwebservices.domain.User;

@Component
public class UserRepository {
	
	private List<User> userList = new ArrayList<>();
	
	public void addUser(User obj){		
		userList.add(obj);
	}
	
	public List<User> findAll(){
		return userList;
	}
	
	public User findById(Integer id) {
		for (User obj : userList) {
			if (obj.getId() == id) {
				return obj;
			}
		}
		return null;
	}
}
