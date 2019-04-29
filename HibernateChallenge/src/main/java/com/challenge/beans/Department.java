package com.challenge.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table(name = "DEPARTMENT")

public class Department {

	public Department() {
		super();
	}
	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "departmentId")
	@SequenceGenerator(allocationSize = 1, name = "departmentId", sequenceName = "SQ_DEPARTMENT_PK")
	@Column(name = "DEPARTMENT_ID")
	private int id;
	
	@Column(name = "NAME")
	private String name;
	
	
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
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
}
