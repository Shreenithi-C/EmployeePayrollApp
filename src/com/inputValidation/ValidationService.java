package com.inputValidation;

import java.util.regex.Pattern;

public class ValidationService {

    private static String sanitize(String input) {
        return input.trim();
    }

    public static void validateEmail(String email) throws EmailValidationException {
        email = sanitize(email);
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!Pattern.matches(regex, email)) {
            throw new EmailValidationException("Invalid Email Format: " + email);
        }
    }

    public static void validatePhone(String phone) throws PhoneValidationException {
        phone = sanitize(phone);
        String regex = "^[0-9]{10}$";
        if (!Pattern.matches(regex, phone)) {
            throw new PhoneValidationException("Invalid Phone Number: " + phone);
        }
    }

    public static void validatePassword(String password) throws PasswordValidationException {
        password = sanitize(password);
        // At least 8 chars, one digit, one special char
        String regex = "^(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$";
        if (!Pattern.matches(regex, password)) {
            throw new PasswordValidationException("Weak Password: must be 8+ chars, include digit & special char");
        }
    }

    public static void validateEmployeeId(String empId) throws EmployeeIdValidationException {
        empId = sanitize(empId);
        String regex = "^EMP-[0-9]{4}$";
        if (!Pattern.matches(regex, empId)) {
            throw new EmployeeIdValidationException("Invalid Employee ID: " + empId + " (Expected EMP-XXXX)");
        }
    }
}
