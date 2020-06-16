package com.educandoweb.springBootDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.springBootDemo.entities.Product;

// Anotação opcional. Devido JpaResporitory já ter anotação indicando ser um repository.
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
