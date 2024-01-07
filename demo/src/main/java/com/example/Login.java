package com.example;

import java.sql.*;

public class Login {
    static public void login() throws SQLException {
        System.out.print("Enter accountnumber : ");
        String accountnumber = InputHandler.inputString();
        System.out.print("Enter password : ");
        String pass = InputHandler.inputString();
        loginValidation(accountnumber, pass);
    }

    static void loginValidation(String accno, String pass) throws SQLException {
        String query = "SELECT * FROM user WHERE accountnumber = ? AND password = ?";
        PreparedStatement statement = DatabaseConnection.databaseConnection().prepareStatement(query);
        statement.setString(1, accno);
        statement.setString(2, pass);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            System.out.println("\n\nLogin successful!\n\n");
            while(true){
                MainDetails.Mswitch();
            }
        } else {
            System.out.println("\n\nInvalid credentials. Login failed.\n\n");
        }
    }
}