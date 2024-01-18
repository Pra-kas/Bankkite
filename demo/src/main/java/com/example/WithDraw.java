package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WithDraw {

    static public List<Object> withDraw() throws Exception {
        System.out.print("Enter account number: ");
        String accountnumber = Hashing.hashing(InputHandler.inputString());
        System.out.print("Enter withdraw amount: ");
        double amount = InputHandler.inputDouble(); 

        if (amount < 500) {
            System.out.println("\n\nWithdraw amount should be at least 500. Withdraw failed.\n\n"); 
        }
        else{
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
            String selectQuery = "SELECT name, accountnumber FROM user WHERE accountnumber = ?";
            PreparedStatement selectStatement = DatabaseConnection.databaseConnection().prepareStatement(selectQuery);
            selectStatement.setString(1, accountnumber);
            ResultSet rs = selectStatement.executeQuery();
            List<Object> result = new ArrayList<>();
            if(rs.next()){
                result.add(rs.getString("name"));
                result.add(rs.getString("accountnumber"));
                result.add("performed withdraw");
            }
            return result;
        }
        return null;
    }
}
