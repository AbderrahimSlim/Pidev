package com.massconnections.Services;

import java.util.List;

import javax.ejb.Remote;

import com.massconnections.Domains.Project;
import com.massconnections.Domains.ProjectCategory;


@Remote
public interface ProjectCategoryServiceRemote {

	public void addProjectCategory(ProjectCategory p);
	public List<ProjectCategory> getProjectCategorys();
	public ProjectCategory getById(int id);
	public void update(ProjectCategory p);
	public void delete(ProjectCategory p);
}
