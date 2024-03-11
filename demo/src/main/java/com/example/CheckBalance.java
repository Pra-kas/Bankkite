package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CheckBalance {
    static public List<Object> checkBalance() throws Exception,SQLException{
        System.out.print("Enter account number : ");
        String accountnumber = Hashing.hashing(InputHandler.inputString());
        String query = "select name,accountbalance,accountnumber from user where accountnumber = ?";
        PreparedStatement statement = DatabaseConnection.databaseConnection().prepareStatement(query);
        statement.setString(1,accountnumber);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            double balance = resultSet.getDouble("accountbalance");
            System.out.println("\n\nYour balance is " + balance + "\n\n");
            List<Object> result = new ArrayList<>();
            result.add(resultSet.getString("name"));
            result.add(resultSet.getString("accountnumber"));
            result.add("Checked balance");
            return result;
        }
        return null;
    }
}
