package com.ems.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import com.ems.util.*;
import com.ems.dao.EmployeeDao;
import com.ems.dao.*;
import com.ems.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao dao;
	public EmployeeServiceImpl() {
		dao=new EmployeeDaoimpl();
	}
	
	@Override
	public boolean validateEmployee(Employee emp) throws Exception {
		
		
		
		String empName=emp.getEmpName();
		LocalDate dob=emp.getDob();
		float salary=emp.getBasicSalary();
		
		if(empName.length()<4 || empName.length()>15) {
			throw new InvalidNameException("Name must be in 4-15 charcters");
		}
		if(dob.isAfter(LocalDate.of(1995, 12,31)) || dob.isBefore(LocalDate.of(1900, 1, 1))) {
			throw new InvalidDobException("Please enter dob in range 01-01-1900 - 31-12-1995");
		}
		
		if(salary>80000 || salary<20000) {
			throw new InvalidSalaryException("Salary should be in range of 20000-80000");
		}
		
		
		return true;
		
	}

	@Override
	public String generateId(String empname) {
		
		String nameChar=empname.substring(0,2).toUpperCase();
		Random rand=new Random();
		int dgt=(int)(rand.nextDouble()*10000);
		return nameChar+dgt;
		
	}

	@Override
	public boolean save(Employee emp) throws Exception {
		
		if(validateEmployee(emp)) {
			emp.setEmpId(generateId(emp.getEmpName()));
			return dao.save(emp);
			
		}
		return false;
		
	}

	@Override
	public boolean delete(String empId) throws Exception {
		return dao.delete(empId);
	
	}

	@Override
	public boolean update(Employee emp) throws Exception {
		if(validateEmployee(emp)) {
			return(dao.update(emp));
		}
		return false;
	}

	@Override
	public Employee getEmployee(String empId) throws Exception {
		return dao.getEmployee(empId);
	}

	@Override
	public List<Employee> getAllEmployees() throws Exception {
		return dao.getAllEmployees();
	}

}