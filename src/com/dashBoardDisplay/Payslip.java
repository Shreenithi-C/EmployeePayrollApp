package com.dashBoardDisplay;

public class Payslip {
    private String month;
    private double netPay;

    public Payslip(String month, double netPay) {
        this.month = month;
        this.netPay = netPay;
    }

    public String getMonth() { return month; }
    public double getNetPay() { return netPay; }

    @Override
    public String toString() {
        return month + " : " + netPay;
    }
}
