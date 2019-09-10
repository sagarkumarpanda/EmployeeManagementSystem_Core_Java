package com.ems.dao;

import java.sql.Connection;
import java.util.List;

import com.ems.model.Employee;

public interface EmployeeDao {

	public Connection getConnection() throws Exception;
	public boolean  save(Employee emp) throws Exception;
	public  boolean  delete (String empId) throws Exception;
	public  boolean update (Employee emp) throws Exception;
	public Employee  getEmployee( String empId) throws Exception;
	public  List<Employee> getAllEmployees() throws Exception;
	
}

