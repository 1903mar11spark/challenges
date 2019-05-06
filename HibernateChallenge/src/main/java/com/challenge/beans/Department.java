package com.challenge.beans;

import javax.persistence.*;

@Entity
@Table (name= "DEPARTMENT")
public class Department 
{
	
	public Department(int id, String name) 
	{
		super();
		this.id = id;
		this.name = name;
	}
	
	
	public Department() 
	{
		super();
	}
	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="departmentSqnce")
	@SequenceGenerator(allocationSize = 5, name = "departmentSqnce", sequenceName="SQ_DEPT_PK")
	@Column(name = "DEPT_ID")
	private int id;
	
	
	
	@Column(name = "NAME")
	private String name;
	
	public int getId() 
	{
		return id;
	}
	
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	
	public String getName() 
	{
		return name;
	}
	
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
}
