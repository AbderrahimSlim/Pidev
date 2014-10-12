package com.massconnections.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.massconnections.Domains.Challenge;
import com.massconnections.Domains.Project;

/**
 * Session Bean implementation class ChallengeCrudEJB
 */
@Stateless
public class ChallengeCrudEJB implements ChallengeCrudEJBRemote, ChallengeCrudEJBLocal {
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ChallengeCrudEJB() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void addChallenge(Challenge c) {
		em.persist(c);
	}
	@Override
	public Challenge getById(int id) {
		Challenge c = em.find(Challenge.class, id);
		return c;
	}
	@Override
	public void update(Challenge c) {
		em.merge(c);
	}
	@Override
	public void delete(Challenge c) {
		em.remove(em.merge(c));	
	}
	
	@Override
	public List<Challenge> getChallenges() {
		return em.createQuery("select p from Challenge p").getResultList();
	}

}
