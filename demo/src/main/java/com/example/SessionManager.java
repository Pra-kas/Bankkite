package com.example;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class SessionManager {

    static void session(List<Object> userdetails) throws SQLException,NullPointerException{
        if(userdetails == null){
            System.out.println("Operation not performed....!\n\n");
        }
        else {
            String username = (String) userdetails.get(0);
            String accountnumber = (String) userdetails.get(1);
            String action = (String)userdetails.get(2);
            String dateTime = DateTime();
            String query = "INSERT INTO session (username, user_id, login_datetime,performed_action) VALUES (?,?,?,?)";
            PreparedStatement statement = DatabaseConnection.databaseConnection().prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, accountnumber);
            statement.setString(3, dateTime);
            statement.setString(4, action);
            int rs =  statement.executeUpdate();
        } 
    }

    static String DateTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return currentDateTime.format(formatter);
    }

    static void LogOut() throws SQLException {
    String dateTime = DateTime();
    String query = "UPDATE session SET logout_datetime = ? WHERE logout_datetime IS NULL";
    try (PreparedStatement statement = DatabaseConnection.databaseConnection().prepareStatement(query)) {
        statement.setString(1, dateTime);
        int rowsUpdated = statement.executeUpdate();

        if (rowsUpdated > 0) {
            System.out.println("Logout recorded successfully.");
        } else {
            System.out.println("No active sessions found to logout.");
        }
    }
}

}
