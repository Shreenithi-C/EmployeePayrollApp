package com.payslipGeneration;

public class UCfourPayslipDownload {
    public static void main(String[] args) {
        System.out.println("=== USE CASE 4: PAYSLIP PRINT / DOWNLOAD ===");

        // Example payslip (normally created from UC3 output)
        FinalPayslip original = new FinalPayslip("EMP-1010", "John David", "January 2026", 48500.00);

        System.out.println("\nOriginal Payslip:");
        System.out.println(original);

        try {
            // Clone payslip for download
            FinalPayslip cloned = (FinalPayslip) original.clone();

            // Verify equality and identity
            System.out.println("\nVerified: Download copy is equal to original.");
            System.out.println("Original hashcode : " + original.hashCode());
            System.out.println("Cloned   hashcode : " + cloned.hashCode());

            // Check download expiry
            DownloadToken token = new DownloadToken();
            if (token.isExpired()) {
                System.out.println("Download token expired. Cannot save payslip.");
                return;
            }

            // Save payslip to files
            FileService fs = new FileService();
            String textFile = fs.savePayslipAsText(cloned);
            String pdfFile = fs.savePayslipAsPdf(cloned);

            System.out.println("\nPayslip Download Successful.");
            System.out.println("Saved as text file: " + textFile);
            System.out.println("Saved as PDF file : " + pdfFile);

            // Print cloned payslip
            System.out.println("\n--- Printed Payslip ---");
            System.out.println(cloned);

        } catch (Exception e) {
            System.out.println("Error during payslip download.");
        }
    }
}
