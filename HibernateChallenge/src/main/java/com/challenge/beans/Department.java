package com.challenge.beans;

import javax.persistence.*;

@Entity
@Table (name= "DEPT")
public class Department {

	public Department() {
		super();
	}
	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Department(String name) {
		super();
		this.name = name;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="deptSequence")
	@SequenceGenerator(allocationSize = 5, name = "deptSequence", sequenceName="SQ_DEPT_PK")
	@Column(name = "DEPT_ID")
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
