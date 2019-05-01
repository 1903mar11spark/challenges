package com.challenge.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name = "EMP")
public class Employee {
	
	public Employee(int id) {
		super();
		this.id = id;
	}
	public Employee( String firstName, String lastName, Department department) {
		super();
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
	}
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
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "empSequence")
	@SequenceGenerator(allocationSize = 1,name = "empSequence", sequenceName= "SQ_EMP_PK")
	@Column(name = "EMP_ID")
	private int id;
	
	@Column(name = "FNAME")
	private String firstName;
	
	@Column(name = "LNAME")
	private String lastName;
	
	@ManyToOne( fetch=FetchType.EAGER)
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
	
	@Override 
	public String toString() {
		return "Employee [id= "+id+", name "+firstName+" "+
	lastName+" , Department "+department+"]";
	}
	
}
