package com.employeeRegistration;

import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;

public class UserAccount {
	
	private String username; 
	private String PasswordHash; 
	public UserAccount(String username, String password) 
	{
		this.username = username; 
		this.PasswordHash = encryptPassword(password); 
	} 
	
	// Password Hashing 
	private String encryptPassword(String password) 
	{ 
		try 
		{ 
			MessageDigest md = MessageDigest.getInstance("SHA-256"); 
			byte[] hash = md.digest(password.getBytes()); 
			StringBuilder sb = new StringBuilder(); 
			for (byte b : hash) { 
				sb.append(String.format("%02x", b)); 
			} 
			return sb.toString(); 
		} 
		catch (NoSuchAlgorithmException e) 
		{ 
			return password; 
	    }
	}
	
	//Getters
	public String getUsername() 
	{
		return username; 
	}
	public String getEncryptedPassword() 
	{
		return PasswordHash; 
	}
}
