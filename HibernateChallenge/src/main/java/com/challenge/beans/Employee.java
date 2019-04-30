package com.challenge.beans;

import javax.persistence.*;

@Entity
@Table (name="EMPL")

public class Employee {

	public Employee(int id, String firstName, String lastName, Department department) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
	}
	public Employee() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="emplSequence")
	@SequenceGenerator(allocationSize = 1, name="emplSequence", sequenceName = "SQ_EMPL_PK")
	@Column(name = "EMPL_ID")
	private int id;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DEPT_ID")
	private Department department;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
}
