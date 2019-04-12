package com.tiosso.rest.microservices.restfulwebservices.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tiosso.rest.microservices.restfulwebservices.domain.User;

@Component
public class UserRepository {
	
	private Integer idCounter = 0;
	private List<User> userList = new ArrayList<>();
	
	public void addUser(User obj){
		if (obj.getId() == null) {
			obj.setId(++idCounter);
			userList.add(obj);
		}
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
	
	public void updateUser(User obj) {
		for (User user : userList) {
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
