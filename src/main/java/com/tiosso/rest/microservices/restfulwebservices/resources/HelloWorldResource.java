package com.tiosso.rest.microservices.restfulwebservices.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiosso.rest.microservices.restfulwebservices.domain.HelloWorldBean;

//Definindo um Controller
@RestController

// Definindo uma rota padrão -  recurso (URI) base
@RequestMapping(path = "/hello-world")

public class HelloWorldResource {

	// Definindo Metodo HTTP, rota URI e Retornando uma string simples
	@GetMapping
	public ResponseEntity<String> helloWorld() {
		return ResponseEntity.ok().body("Hello World !");

	}

	// Definindo Metodo HTTP, rota URI e Retornando um Bean (Objeto)
	@GetMapping(path = "/bean")
	public ResponseEntity<HelloWorldBean> helloWorldBean() {
		HelloWorldBean obj = new HelloWorldBean("Hello World !");
		return ResponseEntity.ok().body(obj);

	}

	// Definindo Metodo HTTP, rota URI e Retornando um Bean (Objeto)
	// Acionando uma Variavel no Path (PathVariable)
	@GetMapping(path = "/bean/{name}")
	public ResponseEntity<HelloWorldBean> helloWorldBean(@PathVariable String name) {
		HelloWorldBean obj = new HelloWorldBean("Hello World, " + name, name);
		return ResponseEntity.ok().body(obj);

	}
}
