package com.massconnections.Services;

import java.util.List;

import javax.ejb.Remote;

import com.massconnections.Domains.ProjectDocument;

@Remote
public interface ProjectDocumentCrudEJBRemote {
	
	public void addProjectDocument(ProjectDocument p);
	public List<ProjectDocument> getProjectDocuments();
	public ProjectDocument getById(int id);
	public void update(ProjectDocument p);
	public void delete(ProjectDocument p);
	
}
