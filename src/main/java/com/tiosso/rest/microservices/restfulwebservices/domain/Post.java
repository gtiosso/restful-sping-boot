package com.tiosso.rest.microservices.restfulwebservices.domain;

import java.io.Serializable;
import java.util.Date;

import com.tiosso.rest.microservices.restfulwebservices.dto.AuthorDto;

public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String title;
	private String content;
	private Date moment;
	private AuthorDto author;

	public Post(Integer id, String title, String content, Date moment, AuthorDto author) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.setMoment(moment);
		this.author = author;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}
	
	public AuthorDto getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDto author) {
		this.author = author;
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
		Post other = (Post) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + "]";
	}
}
