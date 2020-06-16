package com.educandoweb.springBootDemo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.springBootDemo.Services.CategoryService;
import com.educandoweb.springBootDemo.entities.Category;


@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}
	
	// Parametro id indica que será aceito um parâmetro dentro da URL.
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category obj = service.findById(id);
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
