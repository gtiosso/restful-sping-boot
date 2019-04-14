package com.tiosso.rest.microservices.restfulwebservices.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.tiosso.rest.microservices.restfulwebservices.domain.Post;
import com.tiosso.rest.microservices.restfulwebservices.services.listeners.DataChangeListener;

@Component
public class PostRepository {
	
	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();
	private Integer idCounter = 0;
	private Set<Post> postSet = new HashSet<>();
	
	public void subscribeDataChangeListener(DataChangeListener listener) {
		dataChangeListeners.add(listener);
	}
	
	public void insert(Post obj){
		if (obj.getId() == null) {
			obj.setId(++idCounter);
			postSet.add(obj);
		}
	}
	
	public Set<Post> findAll(){
		return postSet;
	}
	
	public Post findById(Integer id) {
		for (Post obj : postSet) {
			if (obj.getId() == id) {
				return obj;
			}
		}
		return null;
	}
	
	public Set<Post> findByAuthorId(Integer id) {
		Set<Post> posts = new HashSet<>();
		for (Post obj : postSet) {
			if (obj.getAuthor().getId() == id) {
				posts.add(obj);
			}
		}
		return posts;
	}
	
	public Post findByAuthorIdPostId(Integer authorId, Integer postId) {
		for (Post obj : postSet) {
			if (obj.getAuthor().getId() == authorId && obj.getId() == postId) {
				return obj;
			}
		}
		return null;
	}
	
	public void update(Post obj) {
		for (Post post : postSet) {
			if (obj.getId() == post.getId()) {
				post.setTitle(obj.getTitle());
				post.setContent(obj.getContent());
				post.setAuthor(obj.getAuthor());
			}
		}
	}
	
	public void delete(Integer id) {
		postSet.removeIf(x -> x.getId() == id);
	}

	public void insertFromUser(Post obj, Integer id) {
		if (obj.getId() == null) {
			obj.setId(++idCounter);
		}
		postSet.add(obj);
		notifyDataChangeListeners(obj);
	}
	
	private void notifyDataChangeListeners(Post post) {
		for (DataChangeListener listener : dataChangeListeners) {
			listener.onDataChanged(post);
		}
		
	}
}
