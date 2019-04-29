package com.challenge.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity // indicates that the class represents a DB entity
@Table(name ="DEPARTMENT")
public class Department {

	//constructors 
	public Department() {
		super();
	}
	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	//instance variables 
	@Id // indicates a primary key 
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "empSequence")
	@SequenceGenerator(allocationSize=1, name="depSequence", sequenceName="SQ_DEP_PK")
	
	@Column(name="DEPARTMENT_ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	//getters and setters 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//toString 
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
}
