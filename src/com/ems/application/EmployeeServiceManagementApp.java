package com.ems.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.StringTokenizer;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;
import com.ems.service.EmployeeServiceImpl;

public class EmployeeServiceManagementApp {
	
		EmployeeService es;
		BufferedReader in;
		
		public EmployeeServiceManagementApp() {
			es=new EmployeeServiceImpl();
			in=new BufferedReader(new InputStreamReader(System.in));
		}
		
		public void addEmployee() throws Exception
		{
			String empName;
			LocalDate dob;
			float sal;
			System.out.println("Enter the Employee details(name,dob(month,date,year),salary :  ");
			empName=in.readLine();
			String strDate = in.readLine();
			StringTokenizer stk =new StringTokenizer(strDate,"-");
			int date =Integer.parseInt(stk.nextToken());
			int month=Integer.parseInt(stk.nextToken());
			int year=Integer.parseInt(stk.nextToken());
			dob=LocalDate.of(year, month, date);
			sal=Float.parseFloat(in.readLine());
			
			
			Employee emp =new Employee();
			emp.setEmpName(empName);
			emp.setBasicSalary(sal);
			emp.setDob(dob);
			
			es.save(emp);
		}
		
		
		
		public void deleteEmployee() {}
		public void showEmployee() {}
		public void displayAll() {}
		public void UpdateEmployee() {}
		
		
		public static void main(String args[])
		{
			EmployeeServiceManagementApp app =new EmployeeServiceManagementApp();
			try {
				app.addEmployee();
			}
			catch(Exception e){
				System.out.println(e);
			}
			
		}
		
	}
	
