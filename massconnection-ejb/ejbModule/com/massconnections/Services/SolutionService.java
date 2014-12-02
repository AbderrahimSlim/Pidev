package com.massconnections.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.massconnections.Domains.Challenge;
import com.massconnections.Domains.Solution;

/**
 * Session Bean implementation class SolutionCrudEJB
 */
@Stateless
public class SolutionService implements SolutionServiceRemote,
		SolutionServiceLocal {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public SolutionService() {
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
		// return em.find(Solution.class, id);
		Solution s = null;
		s = em.createQuery("select p from Solution p where p.id = :id",
				Solution.class).setParameter("id", id).getSingleResult();
		return s;
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
