package com.massconnections.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.massconnections.Domains.Solution;

/**
 * Session Bean implementation class SolutionCrudEJB
 */
@Stateless
public class SolutionCrudEJB implements SolutionCrudEJBRemote, SolutionCrudEJBLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public SolutionCrudEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addSolution(Solution p) {
		em.persist(p);
		
	}

	@Override
	public List<Solution> getSolutions() {
		return em.createQuery("select * from Solution").getResultList();
	}

	@Override
	public Solution getById(int id) {
		return em.find(Solution.class, id);
	}

	@Override
	public void update(Solution p) {
		em.merge(p);
	}

	@Override
	public void delete(Solution p) {
		em.detach(em.merge(p));
	}

}
