package com.massconnections.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.massconnections.Domains.ChallengeCategory;

/**
 * Session Bean implementation class ChallengeCategoryCrudEJB
 */
@Stateless
public class ChallengeCategoryCrudEJB implements ChallengeCategoryCrudEJBRemote, ChallengeCategoryCrudEJBLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ChallengeCategoryCrudEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addChallengeCategory(ChallengeCategory p) {
		em.persist(p);
	}

	@Override
	public List<ChallengeCategory> getChallengeCategorys() {
		return em.createQuery("select cc from ChallengeCategory cc").getResultList();
	}

	@Override
	public ChallengeCategory getById(int id) {
		return em.find(ChallengeCategory.class, id);
	}

	@Override
	public void update(ChallengeCategory p) {
		em.merge(p);
	}

	@Override
	public void delete(ChallengeCategory p) {
		em.remove(em.merge(p));
	}

}
