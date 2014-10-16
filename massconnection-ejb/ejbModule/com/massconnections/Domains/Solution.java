package com.massconnections.Domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Solution implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3332699487846603330L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Lob 
	@Column(name="CONTENT", length=10000)
	private String description;
	
	@OneToMany(mappedBy="solution",cascade=CascadeType.REMOVE)
	private List<SolutionDocument> SolutionDocument = new ArrayList<SolutionDocument>();
	
	@ManyToOne
	@JoinColumn(name="SolverId")
	private Crowd solver;
	
	@ManyToOne
	@JoinColumn(name="challengeId")
	private Challenge challenge;
	
	
	
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
	public Crowd getSolver() {
		return solver;
	}
	public void setSolver(Crowd solver) {
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