package com.massconnections.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.massconnections.Domains.Crowd;

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
	public void addUser(Crowd u) {
		em.persist(u);
	}

	@Override
	public Crowd getById(int id) {
		Crowd u = em.find(Crowd.class, id);
		return u;
	}
	
	

	@Override
	public void update(Crowd u) {
		em.merge(u);
	}

	@Override
	public void delete(Crowd u) {
		 em.remove(em.merge(u));		
	}

	@Override
	public List<Crowd> getUsers() {
		return em.createQuery("select u from User u",Crowd.class).getResultList();
	}
	
    

}
