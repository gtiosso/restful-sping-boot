package com.tiosso.rest.microservices.restfulwebservices.domain;

import java.io.Serializable;

public class HelloWorldBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String msg;

	public HelloWorldBean(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [msg=" + msg + "]";
	}
	
}
