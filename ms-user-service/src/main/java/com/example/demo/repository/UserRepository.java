package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepository {

	User getUser(long userId);
}
