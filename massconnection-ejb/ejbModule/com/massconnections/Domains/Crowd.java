package com.massconnections.Domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Crowd implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8785718556261510247L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String lastName;
	private char sex;
	private String firstName;
	@Column(nullable=true)
	private Date birthDate;
	@Column(nullable=true)
	private String adress;
	private String email;
	@Column(nullable=true)
	private String phone;
	private String login;
	private String password;
	private Date lastLogin;
	private String role;
	
	
	@OneToMany(mappedBy="solver",cascade=CascadeType.ALL)
	private List<Solution> solutions = new ArrayList<Solution>();
	
	
	@OneToMany(mappedBy="donator")
	private List<Donation> donnations = new ArrayList<Donation>();
	
	@OneToMany(mappedBy="creator",cascade=CascadeType.ALL)
	private List<Project> projects = new ArrayList<Project>();

	
	@OneToMany(mappedBy="submitter",cascade=CascadeType.ALL)
	private List<Challenge> challenges = new ArrayList<Challenge>();
	
	@OneToMany(mappedBy="reciever",cascade=CascadeType.ALL)
	private List<Message> inBoxMessages =  new ArrayList<Message>();
	
	@OneToMany(mappedBy="sender",cascade=CascadeType.ALL)
	private List<Message> sendMessages =  new ArrayList<Message>();
	
	public List<Solution> getSolutions() {
		return solutions;
	}
	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
	}
	
	
	
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	
	public List<Donation> getDonnations() {
		return donnations;
	}
	public void setDonnations(List<Donation> donnations) {
		this.donnations = donnations;
	}
	
	
	
	public List<Challenge> getChallenges() {
		return challenges;
	}
	public void setChallenges(List<Challenge> challenges) {
		this.challenges = challenges;
	}
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<Message> getInBox() {
		return inBoxMessages;
	}
	public void setInBox(List<Message> inBox) {
		this.inBoxMessages = inBox;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
}