package com.educandoweb.springBootDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.springBootDemo.entities.OrderItem;
import com.educandoweb.springBootDemo.entities.Product;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
