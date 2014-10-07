package com.massconnections.Domains;

import com.massconnections.Domains.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Donator
 *
 */
@Entity

public class Donator extends User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2360661300067517936L;
	
	@OneToMany(mappedBy="donator")
	private List<Donation> donnations = new ArrayList<Donation>();
	
	public Donator() {
		super();
	}
	
	public List<Donation> getDonnations() {
		return donnations;
	}
	public void setDonnations(List<Donation> donnations) {
		this.donnations = donnations;
	}
   
}
