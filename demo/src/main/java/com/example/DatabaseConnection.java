package com.example;

import java.sql.*;

public class DatabaseConnection {
    static final String DB_URL = "jdbc:mysql://localhost:3306/bankite?useSSL=false";
    static final String USER = "root";
    static final String PASS = "prakash";

    public static Connection databaseConnection() throws SQLException{
        Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
        return con;
    }
};
