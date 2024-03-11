package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Deposit {
    static public List<Object> deposit() throws Exception, SQLException {
        System.out.print("Enter account number: ");
        String accountnumber = Hashing.hashing(InputHandler.inputString());
        System.out.print("Enter deposit amount: ");
        double amount = InputHandler.inputDouble();  // Use inputDouble method from InputHandler

        // SQL query to update the account balance
        String updateQuery = "UPDATE user SET accountbalance = accountbalance + ? WHERE accountnumber = ?";

        try (PreparedStatement statement = DatabaseConnection.databaseConnection().prepareStatement(updateQuery)) {
            statement.setDouble(1, amount);
            statement.setString(2, accountnumber);
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("\n\nDeposit successful. Updated account balance.\n");
            } else {
                System.out.println("\n\nAccount not found or invalid input. Deposit failed.\n\n");
            }
        }

        // Retrieve updated data
        String selectQuery = "SELECT name, accountnumber FROM user WHERE accountnumber = ?";
        PreparedStatement selectStatement = DatabaseConnection.databaseConnection().prepareStatement(selectQuery);
        selectStatement.setString(1, accountnumber);
        ResultSet rs = selectStatement.executeQuery();
        List<Object> result = new ArrayList<>();
        if(rs.next()){
            result.add(rs.getString("name"));
            result.add(rs.getString("accountnumber"));
            result.add("performed deposit");
        }
        return result;
    }
}
