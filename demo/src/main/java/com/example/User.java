package com.example;

public class User {
    private String accountNumber;
    private String password;
    private String name;

    // Constructors, getters, and setters
    public User(String accountNumber, String password,String name) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
