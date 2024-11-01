package com.recipesharing.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static final String URL = "jdbc:mysql://localhost:1251/ORCL";
    private static final String USER = "recipe";
    private static final String PASSWORD = "password";
    private Connection conn;

    // Constructor
    public DBManager() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get the connection
    public Connection getConnection() {
        return conn;
    }

    // Method to close the connection
    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
