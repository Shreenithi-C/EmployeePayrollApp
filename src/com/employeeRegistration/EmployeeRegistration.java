package com.employeeRegistration;

/* 
 @author developer
 @version 1.0
 */

import java.util.*;
import java.io.IOException;

public class EmployeeRegistration {
	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		System.out.println("UC1:Employee Registration");
		
		try 
		{
			System.out.println("Enter Employee ID (EMP-XXXX): ");
			String empId = sc.nextLine();
			Validator.validateEmpId(empId);
			
			System.out.print("Enter Name: "); 
			String name = sc.nextLine(); 
			
			System.out.print("Enter Email: "); 
			String email = sc.nextLine();
			Validator.validateEmail(email);
			
			System.out.print("Enter Phone (10 digits starting 6-9): "); 
			String phone = sc.nextLine(); 
			Validator.validatePhone(phone);
			
			System.out.print("Create Username: "); 
			String username = sc.nextLine();
			
			System.out.print("Create Password: "); 
			String password = sc.nextLine();
			
			UserAccount account = new UserAccount(username, password); 
			Employee emp = new Employee(empId, name, email, phone, account);
			
			emp.persist(); 
			System.out.println("\n-----------------------------------------"); 
			System.out.println("Employee Registered Successfully:"); 
			System.out.println(emp);
			System.out.println("\nData persisted in file: employee_data.txt"); 
			System.out.println("-----------------------------------------");
		}catch (ValidationException e) { 
			System.out.println("\nValidation Failed: " + e.getMessage()); 
		} catch (IOException e) { 
			System.out.println("\nError saving employee data!"); 
		}	
		sc.close();
	}
}
