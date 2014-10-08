package com.massconnections.Domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
public class Project implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 748146505217327813L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String title;
	private String description;
	private boolean state;
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
	@OneToMany(mappedBy="project",cascade=CascadeType.ALL)
	private List<Donation> donations = new ArrayList<Donation>();
	
	@OneToMany(mappedBy="project",cascade=CascadeType.ALL)
	private List<ProjectDocument> projectDocuments = new ArrayList<ProjectDocument>();
	
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
	public List<Donation> getDonations() {
		return donations;
	}
	public void setDonations(List<Donation> donations) {
		this.donations = donations;
	}
	public List<ProjectDocument> getProjectDocuments() {
		return projectDocuments;
	}
	public void setProjectDocuments(List<ProjectDocument> projectDocuments) {
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
	
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public Crowd getCreator() {
		return creator;
	}
	public void setCreator(Crowd creator) {
		this.creator = creator;
	}
	
	
}