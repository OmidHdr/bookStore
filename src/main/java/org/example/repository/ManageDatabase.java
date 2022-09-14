package org.example.repository;

import java.sql.SQLException;

import static org.example.Main.db;
import static org.example.Main.*;

public class ManageDatabase {

    public static boolean flagDatabase = true;


    public static void manageDb() throws SQLException {
        System.out.println("Welcome to managing database option ");
        System.out.println("Enter 'h' for help or 'q' to quit : ");
        key.delete(0, key.length());
        key.append(scanner.nextLine());
        while (flagDatabase == true) {
            switch (key.toString()) {
                case "q":
                    flagDatabase = false;
                    key.delete(0, key.length());
                    break;
                case "h":
                    key.delete(0, key.length());
                    System.out.println("=================================================");
                    System.out.println("press '0' to connect into database ");
                    System.out.println("press '1' to create a database ");
                    System.out.println("press '2' to delete a database ");
                    System.out.println("press '3' to create a table ");
                    System.out.println("press '4' to alter column ");
                    System.out.println("press '5' to add writer ");
                    System.out.print("Enter your number : ");
                    break;
                case "0":
                    key.delete(0,key.length());
                    db.connect();
                    break;
                case "1":
                    System.out.print("Enter your name of database : ");
                    input.append(scanner.nextLine());
                    key.delete(0, key.length());
                    System.out.println("Creating database ... ");
                    if (db.connect() == null) {
                        System.out.println("You almost forgot to connect to database\nso i'd do it for you !!! ");
                        db.connect();
                    }
                    try {
                        db.createDatabase(input.toString());
                        System.out.println("Database Created ");
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Database already exist ");
                    }
                    input.delete(0, input.length());
                    break;
                case "2":
                    key.delete(0, key.length());
                    input.delete(0, input.length());
                    System.out.print("Enter your name of database : ");
                    input.append(scanner.nextLine());
                    System.out.print("Are you sure ? (y/n) : ");
                    key.append(scanner.nextLine());
                    if (key.toString().equals("y")) {
                        if (db.connect() == null) {
                            System.out.println("You almost forgot to connect to database\nso i'd do it for you !!! ");
                            db.connect();
                        }
                        System.out.println();
                        key.delete(0, key.length());
                        try {
                            db.deleteDatabase(input.toString());
                            System.out.println("successfully delete database ");
                        } catch (Exception e) {
                            System.out.println("Can't delete database ");
                        }
                        input.delete(0, input.length());
                    } else System.out.println("you didn't press 'y' so exiting from delete database");
                    break;
                case "3":
                    if (db.connect() == null) {
                        System.out.println("You almost forgot to connect to database\nso i'd do it for you !!! ");
                        db.connect();
                    }

                default:
            }
        }

    }
}
