package com.paresh.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/Student_Management";
    private static final String userName = "root";
    private static final String password = "Mysql@123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,userName,password);
    }
}
