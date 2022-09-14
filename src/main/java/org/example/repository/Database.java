package org.example.repository;

import javax.swing.*;
import java.io.Console;
import java.sql.*;

public class Database {
    static StringBuilder query = new StringBuilder();
    private static final String dbUrl = "jdbc:postgresql://127.0.0.1:5432/postgres";
    private static final String dbUser = "omid";
    private static final String dbPassword = "omgin";
    private static Connection connection = null;

    //section connection
    public static Connection connect() {
//        System.out.println("Connecting to db ! ");
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                System.out.println("Connect to Database successfully ! ");
            }
            return connection;
        } catch (Exception e) {
            System.out.println("failed to connect");
            return null;
        }
    }
    //section create Database
    public static void createDatabase(String dataBase) {
        try {
            query.append("create database ").append(dataBase).append(";");
            PreparedStatement statement = connection.prepareStatement(query.toString());
            statement.execute();
            query.delete(0, query.length());
        } catch (Exception e) {
            System.out.println("Can't create database ! ");
        }
    }

    //section create table
    protected void createTable(String table) {
        try {
            query.append("create table ").append(table).append("();");
            PreparedStatement statement = connection.prepareStatement(query.toString());
            statement.execute();
            query.delete(0, query.length());
        } catch (Exception e) {
            System.out.println("table name already exist ! ");
        }
    }

    //section delete database
    public void deleteDatabase(String name) throws SQLException {
        try{
        query.append("drop database ").append(name).append(";");
        PreparedStatement statement = connection.prepareStatement(query.toString());
        statement.execute();
        query.delete(0, query.length());}
        catch (Exception e){
            System.out.println("Database dosen't exist");
        }
    }

    //section alter table
        static void alterTable (String tableName, String column, String type ) throws SQLException {
            query.append("ALTER TABLE ").append(tableName).append(" ADD COLUMN ").append(column).append(" ").append(type).append(";");
            PreparedStatement statement = connection.prepareStatement(query.toString());
            statement.execute();
            query.delete(0, query.length());
        }
}