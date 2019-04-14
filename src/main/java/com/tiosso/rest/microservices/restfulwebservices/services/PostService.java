package com.tiosso.rest.microservices.restfulwebservices.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiosso.rest.microservices.restfulwebservices.domain.Post;
import com.tiosso.rest.microservices.restfulwebservices.domain.User;
import com.tiosso.rest.microservices.restfulwebservices.repository.PostRepository;
import com.tiosso.rest.microservices.restfulwebservices.services.exceptions.BadRequestException;
import com.tiosso.rest.microservices.restfulwebservices.services.exceptions.ConflictException;
import com.tiosso.rest.microservices.restfulwebservices.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	

	@Autowired
	private PostRepository repo;
	
	public void insert(Post obj) {
		repo.insert(obj);
	}
	
	public Set<Post> findAll(){
		return repo.findAll();
	}
	
	public Post findById(Integer id) {
		Post obj = repo.findById(id);
		// Validando se usuario existe
		if (obj == null) {
			throw new ObjectNotFoundException("ERROR: Object Not Found - ID: " + id);
		}
		return obj;
	}
	
	public void update(Post obj) {
		repo.update(obj);
	}
	
	public void delete(Integer id) {
		repo.delete(id);
	}
	
	public Set<Post> findByAuthorId(Integer id){
		return repo.findByAuthorId(id);
	}
	
	public Post findByAuthorIdPostId(Integer authorId, Integer postId) {
		Post obj = repo.findByAuthorIdPostId(authorId, postId);
		if (obj == null) {
			throw new ObjectNotFoundException("ERROR: Object Not Found - User ID: " + authorId + " - Post ID: " + postId);
		}
		return obj;
	}

	public void insertFromUser(Post obj, Integer id, User user) {
		if (obj.getAuthor().getId() == null) {
			throw new BadRequestException("Author Id is null !");
		}
		if (obj.getAuthor().getId() != id) {
			throw new ConflictException("Author Id is incorrect!");
		}
		if (!obj.getAuthor().getName().equals(user.getName())) {
			throw new ConflictException("Author Name is incorrect!");
		}
		
		
		repo.insertFromUser(obj, id);
	}


	
}
