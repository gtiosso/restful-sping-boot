package com.tiosso.rest.microservices.restfulwebservices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Definindo um Controller
@RestController

public class HelloWorldController {
	
	// Definindo Metodo HTTP, rota URI e Metodo de Resposta
	@GetMapping(path = "/hello-world")
	public ResponseEntity<String> helloWorld() {
		return ResponseEntity.ok().body("Hello World !");
		
	}
	

}
