package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Contact;

@Repository
public class ContactRepositoryImpl implements ContactRepository {
	@PersistenceContext
	private EntityManager em;

	

	@Override
	public List<Contact> getContacts(long userId) {
        TypedQuery<Contact> query = em.createQuery(
                "select dd FROM Contact dd WHERE dd.user_Id =:userId", Contact.class);
        query.setParameter("userId", userId);
        return query.getResultList();
	}

}
