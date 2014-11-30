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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String lastName;
	@Column(nullable=false)
	private char sex;
	private String firstName;
	private Date birthDate;
	private String adress;
	@Column(nullable=false)
	private String email;
	private String phone;
	@Column(nullable=false)
	private String login;
	@Column(nullable=false)
	private String password;
	private String role;
	private String image;
	
	@Override
	public String toString() {
		return lastName +" "+ firstName ;
	}
	@OneToMany(mappedBy="solver",cascade=CascadeType.REMOVE)
	private Set<Solution> solutions = new HashSet<Solution>();
	
	
	@OneToMany(mappedBy="donator",cascade=CascadeType.REMOVE)
	private Set<Donation> donnations = new HashSet<Donation>();
	
	
	@OneToMany(mappedBy="creator",cascade=CascadeType.REMOVE)
	private Set<Project> projects = new HashSet<Project>();

	
	@OneToMany(mappedBy="submitter",cascade=CascadeType.REMOVE)
	private Set<Challenge> challenges = new HashSet<Challenge>();
	
	@OneToMany(mappedBy="reciever",cascade=CascadeType.REMOVE)
	private Set<Message> inBoxMessages =  new HashSet<Message>();
	
	@OneToMany(mappedBy="sender",cascade=CascadeType.REMOVE)
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Crowd other = (Crowd) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}