package com.example;

import java.sql.*;

public class CheckBalance {
    static public void checkBalance() throws Exception{
        System.out.print("Enter account number : ");
        String accountnumber = Hashing.hashing(InputHandler.inputString());
        String query = "select accountbalance from user where accountnumber = ?";
        PreparedStatement statement = DatabaseConnection.databaseConnection().prepareStatement(query);
        statement.setString(1,accountnumber);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            double balance = resultSet.getDouble("accountbalance");
            System.out.println("\n\nYour balance is " + balance + "\n\n");
        }
    }
}
