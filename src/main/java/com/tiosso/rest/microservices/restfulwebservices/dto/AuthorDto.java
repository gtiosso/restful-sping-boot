package com.tiosso.rest.microservices.restfulwebservices.dto;

import com.tiosso.rest.microservices.restfulwebservices.domain.User;

public class AuthorDto {

	private Integer id;
	private String name;

	public AuthorDto() {
	}

	public AuthorDto(User obj) {
		this.id = obj.getId();
		this.name = obj.getName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
