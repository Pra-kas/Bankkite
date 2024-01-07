package com.example;

import java.sql.*;

public class DatabaseConnection {
    static final String DB_URL = "jdbc:mysql://localhost:3306/student?useSSL=false";
    static final String USER = "root";
    static final String PASS = "prakash";
    static String queString = "select * from student_details";

    public static void main(String[] args) throws SQLException{
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queString);

            // Print column headers
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println();

            // Print records
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
    }
}
