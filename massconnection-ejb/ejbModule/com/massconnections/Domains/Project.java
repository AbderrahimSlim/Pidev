package com.massconnections.Domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Project implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 748146505217327813L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String title;
	
	@Lob 
	@Column(name="CONTENT", length=10000)
	private String description;
	private int state;
	private Date deadLine;
	private float amount;
	private Date creationDate;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	private ProjectCategory category;
	
	
	public ProjectCategory getCategory() {
		return category;
	}
	public void setCategory(ProjectCategory category) {
		this.category = category;
	}
	@OneToMany(mappedBy="project")
	private Set<Donation> donations = new HashSet<Donation>();
	
	@OneToMany(cascade=CascadeType.REMOVE)
	private Set<ProjectDocument> projectDocuments = new HashSet<ProjectDocument>();
	
	@ManyToOne
	@JoinColumn(name="UserId")
	private Crowd creator;
	
	
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
	public Date getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Set<Donation> getDonations() {
		return donations;
	}
	public void setDonations(Set<Donation> donations) {
		this.donations = donations;
	}
	public Set<ProjectDocument> getProjectDocuments() {
		return projectDocuments;
	}
	public void setProjectDocuments(Set<ProjectDocument> projectDocuments) {
		this.projectDocuments = projectDocuments;
	}
	public Crowd getUser() {
		return creator;
	}
	public void setUser(Crowd creator) {
		this.creator = creator;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Crowd getCreator() {
		return creator;
	}
	public void setCreator(Crowd creator) {
		this.creator = creator;
	}
	
	
}