package com.educandoweb.springBootDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.springBootDemo.entities.Order;

// Anotação opcional. Devido JpaResporitory já ter anotação indicando ser um repository.
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
