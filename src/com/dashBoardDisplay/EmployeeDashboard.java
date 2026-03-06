package com.dashBoardDisplay;

import java.util.*;

public class EmployeeDashboard implements Dashboard {
    @Override
    public void display(ArrayList<Payslip> payslips, Employee employee) {
        System.out.println("\n=== EMPLOYEE DASHBOARD ===");
        System.out.println("Welcome, " + employee.getName());
        System.out.println("Dashboard Type: " + this.getClass().getName());

        // Sort payslips by netPay descending
        payslips.sort((p1, p2) -> Double.compare(p2.getNetPay(), p1.getNetPay()));

        // Show top 3
        System.out.println("\nRecent Payslips (Top 3):");
        payslips.stream().limit(3).forEach(System.out::println);

        // YTD earnings
        double total = payslips.stream().mapToDouble(Payslip::getNetPay).sum();
        System.out.println("\nYear-To-Date Earnings: " + total);
    }
}
