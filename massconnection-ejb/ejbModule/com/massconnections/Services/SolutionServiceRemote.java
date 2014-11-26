package com.massconnections.Services;

import java.util.List;

import javax.ejb.Remote;

import com.massconnections.Domains.Solution;

@Remote
public interface SolutionServiceRemote {
	
	public void addSolution(Solution p);
	public List<Solution> getSolutions();
	public Solution getById(int id);
	public void update(Solution p);
	public void delete(Solution p);
	
}
