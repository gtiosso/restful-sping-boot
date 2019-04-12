package com.tiosso.rest.microservices.restfulwebservices.domain;

import java.io.Serializable;

public class HelloWorldBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String msg;
	private String name;

	public HelloWorldBean(String msg) {
		this.msg = msg;
	}
	
	public HelloWorldBean(String msg, String name) {
		this.msg = msg;
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	
	}

	@Override
	public String toString() {
		return "HelloWorldBean [msg=" + msg + ", name=" + name + "]";
	}
}
