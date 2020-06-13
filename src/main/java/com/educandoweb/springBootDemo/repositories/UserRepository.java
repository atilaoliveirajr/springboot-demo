package com.educandoweb.springBootDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.springBootDemo.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
