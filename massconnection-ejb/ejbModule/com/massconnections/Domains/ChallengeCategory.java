package com.massconnections.Domains;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ChallengeCategory
 *
 */

@Entity
public class ChallengeCategory implements Serializable {

	   
	
	private int id;
	private String name;
	
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL)
	private List<Challenge> challenges = new ArrayList<Challenge>();

	private static final long serialVersionUID = 1L;

	public ChallengeCategory() {
		super();
	}   
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
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
	
	
	public List<Challenge> getChallenges() {
		return this.challenges;
	}

	public void setChallenges(List<Challenge> challenges) {
		this.challenges = challenges;
	}
   
}
