package com.massconnections.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.massconnections.Domains.User;

/**
 * Session Bean implementation class UserCrudEJB
 */
@Stateless
public class UserCrudEJB implements UserCrudEJBRemote, UserCrudEJBLocal {
	@PersistenceContext
    private EntityManager em;
	
    public UserCrudEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addUser(User u) {
		em.persist(u);
	}

	@Override
	public User getById(int id) {
		User u = em.find(User.class, id);
		return u;
	}
	
	

	@Override
	public void update(User u) {
		em.merge(u);
	}

	@Override
	public void delete(User u) {
		 em.remove(em.merge(u));		
	}

	@Override
	public List<User> getUsers() {
		return em.createQuery("select u from User u",User.class).getResultList();
	}
	
    

}
