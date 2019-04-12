package com.tiosso.rest.microservices.restfulwebservices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiosso.rest.microservices.restfulwebservices.domain.HelloWorldBean;

// Definindo um Controller
@RestController

public class HelloWorldController {
	
	// Definindo Metodo HTTP, rota URI e Retornando uma string simples
	@GetMapping(path = "/hello-world")
	public ResponseEntity<String> helloWorld() {
		return ResponseEntity.ok().body("Hello World !");
		
	}
	
	// Definindo Metodo HTTP, rota URI e Retornando um Bean (Objeto)
	@GetMapping(path = "/hello-world-bean")
	public ResponseEntity<HelloWorldBean> helloWorldBean() {
		HelloWorldBean obj = new HelloWorldBean("Hello World !");
		return ResponseEntity.ok().body(obj);
		
	}
	
	

}
