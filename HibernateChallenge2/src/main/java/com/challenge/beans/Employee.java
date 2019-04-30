package com.challenge.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
@Entity // indicates that the class represents a DB entity
@Table(name ="BAT")
*/

@Entity // indicates that the class represents a DB entity
@Table(name ="EMPLOYEE2")
public class Employee {

	//constructors
	public Employee(int id, String firstName, String lastName, Department department) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
	}
	public Employee(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Employee(String firstName, String lastName, Department department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
	}
	public Employee(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Employee() {
		super();
	}
	
	//instance variables 
	
	@Id // indicates a primary key 
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "empSequence")
	@SequenceGenerator(allocationSize=1, name="empSequence", sequenceName="SQ_EMP_PK")
	
	@Column(name="EMPLOYEE_ID")
	private int id;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;

	@ManyToOne(fetch=FetchType.EAGER)  //this makes CAVE_ID a foreign key for the BAT table ?
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department department;
	
	//getters and setters 
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
	
	//toString
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", department="
				+ department + "]";
	}
}
