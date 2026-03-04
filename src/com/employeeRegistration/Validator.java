package com.employeeRegistration;

import java.util.regex.Pattern;

public class Validator {
	
	// Validate email ID
	public static void validateEmail(String email) throws ValidationException 
	{ 
		String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"; 
		if (!Pattern.matches(regex, email)) 
		{ 
			throw new ValidationException("Invalid Email Format!"); 
		} 
	}
	
	// Validate Phone Number
	public static void validatePhone(String phone) throws ValidationException 
	{
		String regex = "^[6-9][0-9]{9}$"; 
		if (!Pattern.matches(regex, phone)) 
		{
			throw new ValidationException("Invalid Phone Number! Must start with 6-9 and be 10 digits."); 
		} 
	} 
	
	// Validate EmpID
	public static void validateEmpId(String empId) throws ValidationException 
	{ 
		String regex = "^EMP-[0-9]{4}$"; 
		if (!Pattern.matches(regex, empId)) 
		{ 
			throw new ValidationException("Invalid Employee ID! Format: EMP-XXXX"); 
		}
	}
}
