package com.dashBoardDisplay;

import java.util.*;

public class UCfiveDashboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== USE CASE 5: DASHBOARD DISPLAY ===");
        System.out.print("Enter Employee ID: ");
        String empId = sc.nextLine();
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Role (EMPLOYEE/MANAGER): ");
        String role = sc.nextLine();

        Employee emp = new Employee(empId, name, role);

        // Sample payslip data
        ArrayList<Payslip> payslips = new ArrayList<>();
        payslips.add(new Payslip("Jan", 32000));
        payslips.add(new Payslip("Feb", 33000));
        payslips.add(new Payslip("Mar", 34000));
        payslips.add(new Payslip("Apr", 35000));
        payslips.add(new Payslip("May", 36000));

        Dashboard dashboard = DashboardFactory.getDashboard(role);
        if (dashboard != null) {
            dashboard.display(payslips, emp);
        } else {
            System.out.println("Invalid role entered.");
        }
    }
}

