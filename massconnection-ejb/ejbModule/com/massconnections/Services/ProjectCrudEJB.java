package com.massconnections.Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.massconnections.Domains.Project;

/**
 * Session Bean implementation class ProjectCrudEJB
 */
@Stateless
public class ProjectCrudEJB implements ProjectCrudEJBRemote, ProjectCrudEJBLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ProjectCrudEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addProject(Project p) {
		em.persist(p);
		
	}

	@Override
	public List<Project> getProjects() {
		return em.createQuery("select p from Project p").getResultList();
	}

	@Override
	public Project getById(int id) {
		return em.find(Project.class, id);
	}

	@Override
	public void update(Project p) {
		em.merge(p);
	}

	@Override
	public void delete(Project p) {
		em.detach(em.merge(p));
	}
	

}
