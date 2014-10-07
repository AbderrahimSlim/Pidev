package com.massconnections.Domains;

import java.io.File;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class ProjectDocument implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4044376826532601829L;
	private int id;
	private char type;
	private File content;
	
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
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	public File getContent() {
		return content;
	}
	public void setContent(File content) {
		this.content = content;
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