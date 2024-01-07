package com.example;

import java.sql.*;

public class WithDraw {

    static public void withDraw() throws SQLException {
        System.out.print("Enter account number: ");
        String accountnumber = InputHandler.inputString();
        System.out.print("Enter withdraw amount: ");
        double amount = InputHandler.inputDouble(); 

        if (amount < 500) {
            System.out.println("\n\nWithdraw amount should be at least 500. Withdraw failed.\n\n");
            return;  
        }

        String query = "SELECT accountbalance FROM user WHERE accountnumber = ?";
        PreparedStatement statement1 = DatabaseConnection.databaseConnection().prepareStatement(query);
        statement1.setString(1, accountnumber);
        ResultSet resultSet = statement1.executeQuery();
        if (resultSet.next()) {
            double currentBalance = resultSet.getDouble("accountbalance");
            if (currentBalance - amount >= 500) {
                String updateQuery = "UPDATE user SET accountbalance = accountbalance - ? WHERE accountnumber = ?";
                PreparedStatement statement = DatabaseConnection.databaseConnection().prepareStatement(updateQuery);
                statement.setDouble(1, amount);
                statement.setString(2, accountnumber);

                int rowsUpdated = statement.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("\n\nWithdraw successful. Updated account balance.\n\n");
                } 
                else {
                    System.out.println("\n\nWithdraw failed.\n\n");
                }
                }
                else {
                    System.out.println("\n\nMinimum balance should be more than 500. Withdraw failed.\n\n");
                }
        }
        else {
            System.out.println("\n\nAccount not found. Withdraw failed.\n\n");
        }
    }
}
