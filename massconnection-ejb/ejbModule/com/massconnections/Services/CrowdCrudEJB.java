package com.massconnections.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.massconnections.Domains.Crowd;

/**
 * Session Bean implementation class CrowdCrudEJB
 */
@Stateless
public class CrowdCrudEJB implements CrowdCrudEJBRemote, CrowdCrudEJBLocal {
	
	@PersistenceContext
    private EntityManager em;
	
    public CrowdCrudEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addCrowd(Crowd u) {
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
	public List<Crowd> getCrowds() {
		Query query =  em.createQuery("select u from Crowd u LEFT JOIN FETCH u.projects LEFT JOIN FETCH u.challenges where u.role = :r ");
		query.setParameter("r", "C");
		return query.getResultList();
	}
	
	@Override
	public Crowd findCrowdByLogin(String login){
		Query query = em.createQuery("select u from Crowd u where u.login=:l");
		query.setParameter("l", login);
		Crowd found = null;
		try{
			found = (Crowd) query.getSingleResult();
		}catch(Exception e){
		}
		return found;
	}
	
	@Override
	public Crowd findCrowdByMail(String email){
		Query query = em.createQuery("select u from Crowd u where u.email=:e");
		query.setParameter("e", email);
		Crowd found = null;
		try{
			found = (Crowd) query.getSingleResult();
		}catch(Exception e){
			System.out.println("aaa");
		}
		return found;
	}
    

}
