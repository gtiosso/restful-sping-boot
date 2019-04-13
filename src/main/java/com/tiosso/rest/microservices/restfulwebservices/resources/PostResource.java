package com.tiosso.rest.microservices.restfulwebservices.resources;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiosso.rest.microservices.restfulwebservices.domain.Post;
import com.tiosso.rest.microservices.restfulwebservices.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@GetMapping
	public ResponseEntity<Set<Post>> findAll() {
		Set<Post> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable Integer id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
