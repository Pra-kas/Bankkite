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
        StoringInDb(accountnumber, pass,name);}

    static void createAccount() throws SQLException {
        userInputs();
        while(true){
            MainDetails.Mswitch();
        }
    }

    static void StoringInDb(String accno, String pass,String name) throws SQLException {
        String query = "INSERT INTO user (name,accountnumber, password) VALUES (?, ?, ?)";
        PreparedStatement statement = DatabaseConnection.databaseConnection().prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, accno);
        statement.setString(3, pass);

        statement.executeUpdate();

        System.out.println("\n\nAccount created and stored in the database.\n\n");

        statement.close();
    }
}
