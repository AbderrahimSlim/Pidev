package com.massconnections.Domains;

import com.massconnections.Domains.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Creator
 *
 */
@Entity

public class Creator extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3657412828882241059L;
	
	@OneToMany(mappedBy="creator",cascade=CascadeType.ALL)
	private List<Project> projects = new ArrayList<Project>();

	public Creator() {
		super();
	}
	
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
   
}
