package com.employeeRegistration;
/* 
@author developer
@version 2.0
*/
public class UCtwoLoginApp {
	
	public static void main(String[] args) {
        System.out.println("==== USE CASE 2: EMPLOYEE AUTHENTICATION & LOGIN ===");

        AuthenticationService auth = new AuthenticationService();
        Session session = auth.login();

        if (session != null) {
            System.out.println("\n" + session);
            if (!session.isExpired()) {
                System.out.println("Session active and valid.");
            } else {
                System.out.println("Session expired.");
            }
        }
    }
}
