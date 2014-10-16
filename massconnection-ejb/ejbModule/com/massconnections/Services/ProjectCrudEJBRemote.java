package com.massconnections.Services;

import java.util.List;

import javax.ejb.Remote;

import com.massconnections.Domains.Project;

@Remote
public interface ProjectCrudEJBRemote {
	
	public void addProject(Project p);
	public Project getById(int id);
	public void update(Project p);
	public void delete(Project p);
	List<Project> getProjects();
	List<Project> getProjectsWithDonation();
	
}
