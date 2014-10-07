package com.massconnections.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.massconnections.Domains.ProjectDocument;

/**
 * Session Bean implementation class ProjectDocumentCrudEJB
 */
@Stateless
public class ProjectDocumentCrudEJB implements ProjectDocumentCrudEJBRemote, ProjectDocumentCrudEJBLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ProjectDocumentCrudEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addProjectDocument(ProjectDocument p) {
		em.persist(p);
		
	}

	@Override
	public List<ProjectDocument> getProjectDocuments() {
		return em.createQuery("select * from ProjectDocument").getResultList();
	}

	@Override
	public ProjectDocument getById(int id) {
		return em.find(ProjectDocument.class, id);
	}

	@Override
	public void update(ProjectDocument p) {
		em.merge(p);
	}

	@Override
	public void delete(ProjectDocument p) {
		em.detach(em.merge(p));
	}

}
