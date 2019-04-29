package com.challenge.beans;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

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
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "deptSequence")
	@SequenceGenerator(allocationSize = 1, name = "deptSequence", sequenceName = "SQ_D_PK")
	@Column(name = "D_ID")
	private int id;
	
	@Column(name = "DEPT_NAME")
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
