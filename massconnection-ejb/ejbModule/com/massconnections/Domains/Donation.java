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
	private int id;
	private float amount;
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="FK_donatorId")
	private Donator donator;
	
	@ManyToOne
	@JoinColumn(name="FK_projectId")
	private Project project;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
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
	public Donator getDonator() {
		return donator;
	}
	public void setDonator(Donator donator) {
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