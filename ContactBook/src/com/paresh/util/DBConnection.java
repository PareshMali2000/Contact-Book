package com.paresh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/Student_Managemenet";
    private static final String USER_NAME = "rool";
    private static final String PASSWORD = "Mysql@123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER_NAME,PASSWORD);
    }
}
