package com.educandoweb.springBootDemo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.springBootDemo.Services.UserService;
import com.educandoweb.springBootDemo.entities.User;


@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	// Parametro id indica que será aceito um parâmetro dentro da URL.
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

//	Testing H2
//	@GetMapping
//	public ResponseEntity<User> findAll2() {
//		User u = new User(1L, "Maria", "Maria@gmail.com", "99999999", "123456");
//		return ResponseEntity.ok().body(u);
//	
//	}
	

}
