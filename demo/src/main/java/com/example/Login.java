package com.example;

import java.sql.*;

public class Login {
    static public void login() throws Exception {
        System.out.print("Enter accountnumber : ");
        String accountnumber = Hashing.hashing(InputHandler.inputString());
        System.out.print("Enter password : ");
        String pass = Hashing.hashing(InputHandler.inputString());
        User user = new User(accountnumber, pass,"");
        loginValidation(user.getAccountNumber(), user.getPassword());
    }

    static void loginValidation(String accno, String pass) throws Exception {
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