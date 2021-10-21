package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Contact;

@Repository
public interface ContactRepository {

	List<Contact> getContacts(long userId);
}
