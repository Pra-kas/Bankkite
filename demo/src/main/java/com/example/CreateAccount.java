package com.example;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateAccount {
    static void userInputs() throws SQLException {
        System.out.print("Enter your name : ");
        String name = InputHandler.inputString();
        System.out.print("Enter your account number : ");
        String accountnumber = InputHandler.inputString();
        System.out.print("Enter your password : ");
        String pass = InputHandler.inputString();
        System.out.println("Username " + name);
        System.out.println("NAME " + accountnumber);
        System.out.println("PASSWORD " + pass);
        StoringInDb(accountnumber, pass,name);}

    static void createAccount() throws SQLException {
        userInputs();
    }

    static void StoringInDb(String accno, String pass,String name) throws SQLException {
        String query = "INSERT INTO user (name,accountnumber, password) VALUES (?, ?, ?)";
        PreparedStatement statement = DatabaseConnection.databaseConnection().prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, accno);
        statement.setString(3, pass);

        statement.executeUpdate();

        System.out.println("Account created and stored in the database.");

        statement.close();
    }
}
