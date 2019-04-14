package com.tiosso.rest.microservices.restfulwebservices.resources;

import java.net.URI;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tiosso.rest.microservices.restfulwebservices.domain.Post;
import com.tiosso.rest.microservices.restfulwebservices.domain.User;
import com.tiosso.rest.microservices.restfulwebservices.services.PostService;
import com.tiosso.rest.microservices.restfulwebservices.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@Autowired 
	private PostService postService;
	
	@GetMapping
	public ResponseEntity<Set<User>> findAll() {
		Set<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Integer id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> addUser(@Valid @RequestBody User obj){
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> updateUser(@PathVariable Integer id, @RequestBody User obj){
		service.findById(id);
		obj.setId(id);
		service.update(obj);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
		service.findById(id);
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	// DEFININDO POSTS
	
	@GetMapping(path = "/{id}/posts")
	public ResponseEntity<Set<Post>> findByAuthorId(@PathVariable Integer id) {
		service.findById(id);
		Set<Post> list = postService.findByAuthorId(id);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(path = "/{id}/posts/{postId}")
	public ResponseEntity<Post> findByPostId(@PathVariable Integer id, @PathVariable Integer postId) {
		Post obj = postService.findByAuthorIdPostId(id, postId);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(path = "/{id}/posts")
	public ResponseEntity<Void> addUser(@PathVariable Integer id, @RequestBody Post obj){
		User user = service.findById(id);
		postService.insertFromUser(obj, id, user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
