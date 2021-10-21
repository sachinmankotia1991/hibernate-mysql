package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	@PersistenceContext
	private EntityManager em;

	@Override
	public User getUser(long userId) {
		String q = "select dd FROM User dd WHERE dd.user_id =:userId";
		TypedQuery<User> query = em.createQuery(q, User.class);
		query.setParameter("userId", userId);
		return DataAccessUtils.singleResult(query.getResultList());
	}

}
