package com.employeeRegistration;

public class Session {
    private String username;
    private long loginTime;
    private long timeoutMillis;

    public Session(String username) {
        this.username = username;
        this.loginTime = System.currentTimeMillis();
        this.timeoutMillis = 5 * 60 * 1000; // 5 minutes
    }

    public boolean isExpired() {
        return System.currentTimeMillis() - loginTime > timeoutMillis;
    }

    @Override
    public String toString() {
        return "Session active for user: " + username;
    }
}
