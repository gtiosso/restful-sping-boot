package com.tiosso.rest.microservices.restfulwebservices.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.tiosso.rest.microservices.restfulwebservices.domain.Post;
import com.tiosso.rest.microservices.restfulwebservices.domain.User;
import com.tiosso.rest.microservices.restfulwebservices.dto.AuthorDto;
import com.tiosso.rest.microservices.restfulwebservices.repository.PostRepository;
import com.tiosso.rest.microservices.restfulwebservices.repository.UserRepository;

// Declara que esta classe possui metodos que dever ser gerados no momento da inicializacao
@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PostRepository postRepo;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		User u1 = new User(null, "Guilherme Tiosso", "guilherme.tiosso@gmail.com", sdf.parse("26/06/1992"));
		User u2 = new User(null, "Janaina Tiosso", "janaina.tiosso@gmail.com", sdf.parse("10/03/1989"));
		User u3 = new User(null, "Iara Tiosso", "iara.tiosso@gmail.com", sdf.parse("24/07/2010"));
		User u4 = new User(null, "Isabella Tiosso", "isabella.tiosso@gmail.com", sdf.parse("10/01/2018"));

		repo.insert(u1);
		repo.insert(u2);
		repo.insert(u3);
		repo.insert(u4);
		
		Post p1 = new Post(null, "Viagem Doida", "Partiu viajar galera !", new Date(), new AuthorDto(u1));
		Post p2 = new Post(null, "Sente o Cheiro", "Olha o jantar que eu preparei !", new Date(), new AuthorDto(u2));
		Post p3 = new Post(null, "Jogo Incrivel", "Que jogo mais legal, doida para terminar", new Date(), new AuthorDto(u3));
		Post p4 = new Post(null, "Boneca Barbie", "Ganhei minha primeira Barbie !", new Date(), new AuthorDto(u4));
		Post p5 = new Post(null, "Papinha", "A mamae fez a melhor papinha do mundo", new Date(), new AuthorDto(u4));
		
		postRepo.insert(p1);
		postRepo.insert(p2);
		postRepo.insert(p3);
		postRepo.insert(p4);
		postRepo.insert(p5);
		
		u1.setPosts(Arrays.asList(p1));
		u2.setPosts(Arrays.asList(p2));
		u3.setPosts(Arrays.asList(p3));
		u4.setPosts(Arrays.asList(p4, p5));
	}
}
