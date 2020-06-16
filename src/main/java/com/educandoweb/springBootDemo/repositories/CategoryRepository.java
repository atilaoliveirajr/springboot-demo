package com.educandoweb.springBootDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.springBootDemo.entities.Category;
import com.educandoweb.springBootDemo.entities.User;

// Anotação opcional. Devido JpaResporitory já ter anotação indicando ser um repository.
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
