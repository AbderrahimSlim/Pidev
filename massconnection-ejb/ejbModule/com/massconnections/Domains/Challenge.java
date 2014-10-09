package com.massconnections.Domains;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Challenge implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 845955225084562866L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String title;
	@Column(nullable=true)
	private String description;
	@Column(nullable=true)
	//xcvkg
	private int state;
	@ManyToOne
	@JoinColumn(name="categoryID")
	private ChallengeCategory category;
	
	
	@ManyToOne
	@JoinColumn(name="UserId")
	private Crowd submitter;
	
	@OneToMany(mappedBy="challenge",cascade=CascadeType.ALL)
	private List<Solution> solutions;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Solution> getSolutions() {
		return solutions;
	}
	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Crowd getUser() {
		return submitter;
	}
	public void setUser(Crowd submitter) {
		this.submitter = submitter;
	}
	public ChallengeCategory getCategory() {
		return category;
	}
	public void setCategory(ChallengeCategory category) {
		this.category = category;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Crowd getSubmitter() {
		return submitter;
	}
	public void setSubmitter(Crowd submitter) {
		this.submitter = submitter;
	}
	
	
}