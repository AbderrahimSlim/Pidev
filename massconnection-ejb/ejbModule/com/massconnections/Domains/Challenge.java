package com.massconnections.Domains;

import java.io.Serializable;
import java.util.Date;
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
public class Challenge implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 845955225084562866L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	
	private Date deadLine;
	private Date startDate;
	
	
	@Lob 
	@Column(name="CONTENT", length=10000, nullable=true)
	private String description;
	
	@Column(nullable=true)
	
	private int state;
	@ManyToOne
	@JoinColumn(name="categoryID")
	private ChallengeCategory category;
	
	
	@ManyToOne
	@JoinColumn(name="UserId")
	private Crowd submitter;
	
	@OneToMany(mappedBy="challenge",cascade=CascadeType.REMOVE)
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}
	
	
}