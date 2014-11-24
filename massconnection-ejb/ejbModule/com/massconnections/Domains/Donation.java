package com.massconnections.Domains;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Donation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2434695396229313945L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private float amount;
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="donatorId")
	private Crowd donator;
	
	@ManyToOne
	@JoinColumn(name="projectId")
	private Project project;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Crowd getUser() {
		return donator;
	}
	public void setUser(Crowd donator) {
		this.donator = donator;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}