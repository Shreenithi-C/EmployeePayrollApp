package com.employeeRegistration;

import java.util.*;

public class AuthenticationService {
    private Map<String, User> users = new HashMap<>();
    private int maxAttempts = 3;

    public AuthenticationService() {
        // Predefined demo users
        users.put("emp1", new RegularEmployee("emp1", "Emp@1234"));
        users.put("manager1", new Manager("manager1", "Mng@1234"));
    }

    public Session login() {
        Scanner sc = new Scanner(System.in);
        int attempts = 0;

        while (attempts < maxAttempts) {
            System.out.print("Enter Username: ");
            String username = sc.nextLine();
            System.out.print("Enter Password: ");
            String password = sc.nextLine();
     
            User user = users.get(username);
            if (user != null && user.authenticate(username, password)) {
                System.out.println("\nLogin Successful!");
                System.out.println("Role: " + user.getRole());

                Session session = new Session(username);
                showDashboard(user.getRole());
                return session;
            } else {
                attempts++;
                System.out.println("Invalid credentials. Attempts left: " + (maxAttempts - attempts));
            }
        }
        System.out.println("Login failed. Too many attempts.");
        return null;
    }

    private void showDashboard(String role) {
        System.out.println("\n======= DASHBOARD =======");
        if (role.equals("EMPLOYEE")) {
            System.out.println("Employee Dashboard");
            System.out.println("View Payslip | Update Profile");
        } else if (role.equals("MANAGER")) {
            System.out.println("Manager Dashboard");
            System.out.println("View Reports | Manage Team");
        }
    }

}
