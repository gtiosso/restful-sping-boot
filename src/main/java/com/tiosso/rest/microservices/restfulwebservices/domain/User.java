package com.tiosso.rest.microservices.restfulwebservices.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	@Size(max = 30, message = "Name should have 30 char atMax!")
	@NotNull(message = "Name can not be null!")
	private String name;
	@NotNull(message = "Email can not be null!")
	@Pattern(regexp = "[a-z0-9]+(([\\.\\-][a-z0-9]+)+)?[\\@][a-z]+(([\\.][a-z]+)+)?", message = "Email format is wrong!")
	private String email;
	
	@Past
	// Realiza o Parse de String para Data, isso para o retorno do JSON (Rest)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date birthDate;
	
	private List<Post> posts = new ArrayList<>();

	public User() {
	}
	
	public User(Integer id, String name, String email, Date birthDate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", birthDate=" + birthDate + ", posts="
				+ posts + "]";
	}

}
