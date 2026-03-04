package com.employeeRegistration;

import java.io.FileWriter; 
import java.io.IOException;

public class Employee {
	private String empId; 
	private String name; 
	private String email; 
	private String phone; 
	private UserAccount account; 
	
	// Constructor Overloading 
	public Employee(String empId, String name, String email, String phone) 
	{
		this(empId, name, email, phone, null); 
	}
	public Employee(String empId, String name, String email, String phone, UserAccount account) 
	{
		this.empId = empId; 
		this.name = name; 
		this.email = email; 
		this.phone = phone; 
		this.account = account; 
	}
	
	@Override 
	public String toString() 
	{ 
		return "Employee ID : " + empId + 
				"\nName : " + name + 
				"\nEmail : " + email + 
				"\nPhone : " + phone + 
				(account != null ? "\nUsername : " + account.getUsername() : ""); 
	}
	
	public void persist() throws IOException 
	{
		try (FileWriter fw = new FileWriter("employee_data.txt", true)) 
		{ 
			fw.write(this.toString() + "\n\n"); 
		} 
	}
}
