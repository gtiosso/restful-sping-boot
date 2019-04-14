package com.tiosso.rest.microservices.restfulwebservices.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tiosso.rest.microservices.restfulwebservices.domain.Post;
import com.tiosso.rest.microservices.restfulwebservices.domain.User;
import com.tiosso.rest.microservices.restfulwebservices.services.listeners.DataChangeListener;

@Component
public class UserRepository  implements DataChangeListener {
	
	@Autowired
	private PostRepository repo;
	
	private Integer idCounter = 0;
	private Set<User> userSet = new HashSet<>();
	
	public void insert(User obj){
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
				repo.subscribeDataChangeListener(this);
				return obj;
			}
		}
		return null;
	}
	
	public void update(User obj) {
		for (User user : userSet) {
			if (obj.getId() == user.getId()) {
				user.setName(obj.getName());
				user.setEmail(obj.getEmail());
				user.setBirthDate(obj.getBirthDate());
			}
		}
	}
	
	public void delete(Integer id) {
		userSet.removeIf(x -> x.getId() == id);
	}
	
	@Override
	public void onDataChanged(Post post) {
		List<Post> posts = new ArrayList<>();
		for (User user : userSet) {
			if (post.getAuthor().getId() == user.getId()) {
				for (Post item : user.getPosts()) {
					posts.add(item);
				}
				posts.add(post);
				user.setPosts(posts);
			}
		}
		
	}
}
