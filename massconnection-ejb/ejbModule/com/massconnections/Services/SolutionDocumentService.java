package com.massconnections.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.massconnections.Domains.SolutionDocument;

/**
 * Session Bean implementation class SolutionDocumentCrudEJB
 */
@Stateless
public class SolutionDocumentService implements SolutionDocumentServiceRemote,SolutionDocumentServiceLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public SolutionDocumentService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addSolutionDocument(SolutionDocument p) {
		em.persist(p);
		
	}

	@Override
	public List<SolutionDocument> getSolutionDocuments() {
		return em.createQuery("select * from SolutionDocument").getResultList();
	}

	@Override
	public SolutionDocument getById(int id) {
		return em.find(SolutionDocument.class, id);
	}

	@Override
	public void update(SolutionDocument p) {
		em.merge(p);
	}

	@Override
	public void delete(SolutionDocument p) {
		em.detach(em.merge(p));
	}

}
