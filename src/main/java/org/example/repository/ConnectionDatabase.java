package org.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {

    private ConnectionDatabase() {
    }

    private static Connection con = null;

    static
    {
        final String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
        final String user = "omid";
        final String pass = "omgin";
        try {
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return con;
    }
}