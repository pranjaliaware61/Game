package com.example.BookManagement.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookManagement.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
