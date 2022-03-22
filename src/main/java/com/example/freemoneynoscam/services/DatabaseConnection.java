package com.example.freemoneynoscam.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection = null;

    static
    {
        String url = "jdbc:mysql://localhost:3306/free_money";
        String user = "root";
        String pass = "KeaDb2022";
        try {
            connection = DriverManager.getConnection(url, user, pass);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return connection;
    }
}