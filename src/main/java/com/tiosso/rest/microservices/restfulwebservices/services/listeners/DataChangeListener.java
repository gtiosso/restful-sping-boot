package com.tiosso.rest.microservices.restfulwebservices.services.listeners;

import com.tiosso.rest.microservices.restfulwebservices.domain.Post;

public interface DataChangeListener {
	
	void onDataChanged(Post post);

}
