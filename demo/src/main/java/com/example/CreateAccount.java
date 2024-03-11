package com.example;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateAccount {
    static void userInputs() throws Exception {
        System.out.print("Enter your name : ");
        String name = InputHandler.inputString();
        System.out.print("Enter your account number : ");
        String accountnumber = Hashing.hashing(InputHandler.inputString());
        System.out.print("Enter your password : ");
        String pass = Hashing.hashing(InputHandler.inputString());
        User user = new User(accountnumber,pass,name);
        StoringInDb(user.getAccountNumber(),user.getPassword(),user.getName());
    }

    static void createAccount() throws Exception {
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
