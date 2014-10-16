package com.massconnections.Domains;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	private Set<Solution> solutions = new HashSet<Solution>();
	
	
	@OneToMany(mappedBy="donator")
	private Set<Donation> donnations = new HashSet<Donation>();
	
	
	@OneToMany(mappedBy="creator",cascade=CascadeType.REMOVE)
	private Set<Project> projects = new HashSet<Project>();

	
	@OneToMany(mappedBy="submitter",cascade=CascadeType.REMOVE)
	private Set<Challenge> challenges = new HashSet<Challenge>();
	
	@OneToMany(mappedBy="reciever")
	private Set<Message> inBoxMessages =  new HashSet<Message>();
	
	@OneToMany(mappedBy="sender")
	private Set<Message> sendMessages =  new HashSet<Message>();
	
	public Set<Solution> getSolutions() {
		return solutions;
	}
	public void setSolutions(Set<Solution> solutions) {
		this.solutions = solutions;
	}
	
	
	
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	
	
	public Set<Donation> getDonnations() {
		return donnations;
	}
	public void setDonnations(Set<Donation> donnations) {
		this.donnations = donnations;
	}
	
	
	
	public Set<Challenge> getChallenges() {
		return challenges;
	}
	public void setChallenges(Set<Challenge> challenges) {
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
	
	public int getAge() {
        Date dateCourante = new Date();
        int age;
        age = dateCourante.getYear() - this.getBirthDate().getYear();
        if (getBirthDate().after(dateCourante)) {
            age = age - 1;
        }
        return age;
    }

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Set<Message> getInBox() {
		return inBoxMessages;
	}
	public void setInBox(Set<Message> inBox) {
		this.inBoxMessages = inBox;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
}