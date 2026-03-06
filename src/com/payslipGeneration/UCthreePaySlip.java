package com.payslipGeneration;

import java.util.Scanner;
/*
@author developer
@version 3.0
*/
public class UCthreePaySlip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== USE CASE 3: PAYSLIP GENERATION ===");
        System.out.print("Enter Employee ID: ");
        String empId = sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Month (e.g., January 2026): ");
        String month = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        double basic = sc.nextDouble();

        System.out.print("Enter HRA: ");
        double hra = sc.nextDouble();

        System.out.print("Enter DA: ");
        double da = sc.nextDouble();

        System.out.print("Enter Allowances: ");
        double allowances = sc.nextDouble();

        Employee emp = new Employee(empId, name);
        PayrollService service = new PayrollService();
        Payslip payslip = service.generatePayslip(emp, month, basic, hra, da, allowances);

        System.out.println(payslip);

        sc.close();
    }
}

