package com.massconnections.Domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Solution implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3332699487846603330L;
	private int id;
	private String description;
	
	@OneToMany(mappedBy="solution",cascade=CascadeType.ALL)
	private List<SolutionDocument> SolutionDocument = new ArrayList<SolutionDocument>();
	
	@ManyToOne
	@JoinColumn(name="FK_SolverId")
	private User solver;
	
	@ManyToOne
	@JoinColumn(name="FK_challengeId")
	private Challenge challenge;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<SolutionDocument> getSolutionDocument() {
		return SolutionDocument;
	}
	public void setSolutionDocument(List<SolutionDocument> solutionDocument) {
		SolutionDocument = solutionDocument;
	}
	public User getSolver() {
		return solver;
	}
	public void setSolver(User solver) {
		this.solver = solver;
	}
	public Challenge getChallenge() {
		return challenge;
	}
	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}