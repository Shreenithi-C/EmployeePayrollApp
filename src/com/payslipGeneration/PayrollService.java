package com.payslipGeneration;

public class PayrollService {
    public Payslip generatePayslip(Employee employee, String month,
                                   double basic, double hra, double da, double allowances) {

        SalaryComponents sc = new SalaryComponents(basic, hra, da, allowances);

        // Gross salary
        double gross = basic + hra + da + allowances;

        // Deductions
        sc.pf = basic * 0.12;   // Provident Fund (12%)
        sc.tax = gross * 0.10;  // Income Tax (10%) - demo rule

        // Net Pay
        sc.netPay = gross - (sc.pf + sc.tax);

        return new Payslip(employee, sc, month);
    }
}
