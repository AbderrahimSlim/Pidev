package com.massconnections.Domains;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ProjectCategory
 *
 */
@Entity

public class ProjectCategory implements Serializable {

	   
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5264591379064090299L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String name;
	
	@OneToMany(mappedBy="category")
	private List<Project> projects = new ArrayList<Project>();

	public ProjectCategory() {
		super();
	}   
	
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
   
}
