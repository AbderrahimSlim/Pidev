package com.massconnections.Domains;

import com.massconnections.Domains.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Submitter
 *
 */
@Entity

public class Submitter extends User implements Serializable {


	private static final long serialVersionUID = -7835511005250270254L;
	
	@OneToMany(mappedBy="submitter",cascade=CascadeType.ALL)
	private List<Challenge> challenges = new ArrayList<Challenge>();
	
	public Submitter() {
		super();
	}
	

	public List<Challenge> getChallenges() {
		return challenges;
	}
	public void setChallenges(List<Challenge> challenges) {
		this.challenges = challenges;
	}
   
}
