package com.massconnections.Services;

import java.util.List;

import javax.ejb.Remote;

import com.massconnections.Domains.SolutionDocument;

@Remote
public interface SolutionDocumentCrudEJBRemote {
	
	public void addSolutionDocument(SolutionDocument p);
	public SolutionDocument getById(int id);
	public void update(SolutionDocument p);
	public void delete(SolutionDocument p);
	List<SolutionDocument> getSolutionDocuments();
	
}
