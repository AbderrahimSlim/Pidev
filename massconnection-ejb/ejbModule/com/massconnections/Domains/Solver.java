package com.massconnections.Domains;

import com.massconnections.Domains.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Solver
 *
 */
@Entity
public class Solver extends User implements Serializable {
	
	@OneToMany(mappedBy="solver",cascade=CascadeType.ALL)
	private List<Solution> solutions = new ArrayList<Solution>();
	
	
	public List<Solution> getSolutions() {
		return solutions;
	}
	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5818055861299648752L;

	public Solver() {
		super();
	}
   
}
