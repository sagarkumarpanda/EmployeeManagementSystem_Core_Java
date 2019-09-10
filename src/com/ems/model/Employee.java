package com.ems.model;

import java.time.*;

public class Employee {

	String empId;
	String empName;
	LocalDate dob;
	float basicSalary;
	
	public Employee() {
		
		
	}
	
	public Employee(String empId,String empname,LocalDate dob,float basicSalary)
	{
		this.empId=empId;
		this.empName=empName;
		this.dob=dob;
		this.basicSalary=basicSalary;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}

	public String getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public float getBasicSalary() {
		return basicSalary;
	}
	
	
}
