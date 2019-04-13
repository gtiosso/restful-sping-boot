package com.tiosso.rest.microservices.restfulwebservices.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.tiosso.rest.microservices.restfulwebservices.domain.User;

@Component
public class UserRepository {
	
	private Integer idCounter = 0;
	private Set<User> userSet = new HashSet<>();
	private List<User> userList = new ArrayList<>();
	
	public void addUser(User obj){
		if (obj.getId() == null) {
			obj.setId(++idCounter);
			userSet.add(obj);
		}
	}
	
	public Set<User> findAll(){
		return userSet;
	}
	
	public User findById(Integer id) {
		for (User obj : userSet) {
			if (obj.getId() == id) {
				return obj;
			}
		}
		return null;
	}
	
	public void updateUser(User obj) {
		for (User user : userSet) {
			if (obj.getId() == user.getId()) {
				user.setName(obj.getName());
				user.setEmail(obj.getEmail());
				user.setBirthDate(obj.getBirthDate());
			}
		}
	}
	
	public void removeUser(Integer id) {
		userList.removeIf(x -> x.getId() == id);
	}
}
