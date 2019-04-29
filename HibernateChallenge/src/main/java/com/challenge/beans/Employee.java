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



@NamedQueries({ @NamedQuery(name = "getAllEmps", query = "from Employee"), // notice this is HQL - not referencing
	// tables/columns, but Java objects
@NamedQuery(name = "getEmpsByDept", query = "from Employee where dept.id = :deptVar") })

@Entity
@Table(name = "EMPLOYEE")
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
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "empSequence")
	@SequenceGenerator(allocationSize = 1, name = "empSequence", sequenceName = "SQ_EMP_PK")
	@Column(name = "EMP_ID")
	private int id;
	
	@Column(name = "FIRSTNAME")
	private String firstName;
	
	@Column(name = "LASTNAME")
	private String lastName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DEPT_ID")
	private Department department;
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", department="
				+ department + "]";
	}
	
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
