package com.example;

import java.sql.*;

public class Transfer {

    static public void transfer() throws Exception {
        System.out.print("Enter your account number : ");
        String user_accountnumber = Hashing.hashing(InputHandler.inputString());

        System.out.print("Enter recipient account number : ");
        String recipient_accountnumber = Hashing.hashing(InputHandler.inputString());

        System.out.print("Re-enter recipient account number : ");
        String re_entered_accountnumber = Hashing.hashing(InputHandler.inputString());

        System.out.print("Enter transfer amount : ");
        double transfer_amount = InputHandler.inputDouble();

        if (transfer_amount < 5.0) {
            System.out.println("Minimum transaction amount is $5 ");
            return;
        }

        if (transfer_amount > 100000.0) {
            System.out.println("Maximum transaction amount is $100000 ");
            return;
        }

        if (!recipient_accountnumber.equals(re_entered_accountnumber)) {
            System.out.println("Incorrect account number..!");
            return;
        }

        if (!isUserFound(user_accountnumber) || !isUserFound(recipient_accountnumber)) {
            System.out.println("User not found. Transfer failed..!");
            return;
        }

        String updateQuery = "UPDATE user SET accountbalance = accountbalance - ? WHERE accountnumber = ?";
        try (PreparedStatement statement3 = DatabaseConnection.databaseConnection().prepareStatement(updateQuery)) {
            statement3.setDouble(1, transfer_amount);
            statement3.setString(2, user_accountnumber);
            statement3.executeUpdate();
        }

        updateQuery = "UPDATE user SET accountbalance = accountbalance + ? WHERE accountnumber = ?";
        PreparedStatement statement2 = DatabaseConnection.databaseConnection().prepareStatement(updateQuery);
        statement2.setDouble(1, transfer_amount);
        statement2.setString(2, recipient_accountnumber);
        statement2.executeUpdate();

        System.out.println("Transfer successful!");
    }

    static boolean isUserFound(String accountnumber) throws SQLException {
        String query = "SELECT accountbalance FROM user WHERE accountnumber = ?";
        PreparedStatement statement = DatabaseConnection.databaseConnection().prepareStatement(query);
        statement.setString(1, accountnumber);
        ResultSet rs = statement.executeQuery();
        return rs.next();
    }
}
