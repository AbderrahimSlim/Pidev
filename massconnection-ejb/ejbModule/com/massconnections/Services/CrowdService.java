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
public class CrowdService implements CrowdServiceRemote,CrowdServiceLocal {
	
	@PersistenceContext
    private EntityManager em;
	
    public CrowdService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addCrowd(Crowd u) {
		em.persist(u);
	}

	@Override
	public Crowd getById(int id) {
		Query query =  em.createQuery("select distinct u from Crowd u join FETCH u.projects p left join fetch u.challenges c left join fetch u.donnations d where u.id = :id ",Crowd.class);
		query.setParameter("id", id);
		return (Crowd) query.getSingleResult();
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
		Query query =  em.createQuery("select u from Crowd u where u.role = :r ");
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
			
		}
		return found;
	}

	@Override
	public Crowd Authentification(String login, String password,String role) {
		Query query = em.createQuery("select u from Crowd u where u.login = :login and u.password= :password and u.role= :role ");
		query.setParameter("login", login);
		query.setParameter("password", password);
		query.setParameter("role", role);
		
		Crowd found = null;
		try{
			found = (Crowd) query.getSingleResult();
		}catch(Exception e){
		}
		return found;
	}
    

}
