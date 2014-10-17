package com.massconnections.Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.massconnections.Domains.ProjectCategory;

/**
 * Session Bean implementation class ProjectCategoryCrudEJB
 */
@Stateless
public class ProjectCategoryCrudEJB implements ProjectCategoryCrudEJBRemote, ProjectCategoryCrudEJBLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ProjectCategoryCrudEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addProjectCategory(ProjectCategory p) {
		em.persist(p);
		
	}

	@Override
	public List<ProjectCategory> getProjectCategorys() {
		return em.createQuery("select pc from ProjectCategory pc").getResultList();
	}

	@Override
	public ProjectCategory getById(int id) {
		return em.find(ProjectCategory.class, id);
	}

	@Override
	public void update(ProjectCategory p) {
		em.merge(p);
	}

	@Override
	public void delete(ProjectCategory p) {
		em.remove(em.merge(p));
	}

}
