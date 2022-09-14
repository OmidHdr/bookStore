package org.example;

import org.example.model.Author;
import org.example.repository.ConnectionDatabase;
import org.example.repository.Database;
import org.example.repository.ManageDatabase;
import org.example.service.AuthorService;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // initialize some variable
    public static Scanner scanner = new Scanner(System.in);
    public static Database db = new Database();
    public static StringBuilder input = new StringBuilder();
    public static StringBuilder key = new StringBuilder();
    public static Connection connect = ConnectionDatabase.getConnection();
    static AuthorService authorService = new AuthorService();
    public static boolean flag = true;
    static String[] items = {"first name : " , "last name : " , "phone number : " , "birthday : "};
    // end of initialize

    //section run
    public static void run() {
        key.append(scanner.nextLine());
        switch (key.toString()) {
            case "q":
                flag = false;
                key.delete(0, key.length());
                break;
            case "h":
                key.delete(0,key.length());
                System.out.println("==============================================");
                System.out.println("Press '0' to manage database ");
                System.out.println("Press '1' to add a author ");
                System.out.println("Press '2' to delete a author ");
                System.out.println("Press '3' to update a author ");
                break;
            case "0":
                key.delete(0,key.length());
                try {
                    ManageDatabase.manageDb();
                } catch (SQLException e) {
                    System.out.println("Failed to connect into manage database class ! ");
                }
                break;
            case "1":
                key.delete(0,key.length());
                if (db.connect() == null){
                    System.out.println("connecting to database ...  ");
                    db.connect();
                }
                try{
                    String[] items2 = new String[4];
                    int i = 0 ;
                    for (String item : items) {
                        System.out.println("Enter your " + item);
                        items2[i] = scanner.nextLine();
                        i ++ ;
                    }
                    System.out.println("Enter your gender : ");
                    Author author = new Author(items2[0], items2[1],scanner.next().charAt(0),
                            items2[2], Date.valueOf(items2[3]));
                    authorService.buildAuthor(author);
                    Arrays.fill(items2,null);
                }catch (Exception e ){
                    e.printStackTrace();
                }
                break;
            case "2":
                key.delete(0,key.length());
                if (db.connect() == null){
                    db.connect();
                }
                try {
                    System.out.print("Enter your id to remove author : ");
                    Author author = new Author(scanner.nextInt());
                    AuthorService.deleteAuthor(author);
                    System.out.println("You removed item " + author.getId());
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case "3":
                key.delete(0,key.length());
                if (db.connect() == null){
                    System.out.println("connecting to database ...  ");
                    db.connect();
                }
                try {
                    String[] items2 = new String[4];
                    int i = 0 ;
                    for (String item : items) {
                        System.out.println("Enter your " + item);
                        items2[i] = scanner.nextLine();
                        i ++ ;
                    }
                    System.out.println("Enter your id : ");
                    int id = scanner.nextInt();
                    System.out.println("Enter your gender : ");
                    Author author = new Author(id,items2[0], items2[1],scanner.next().charAt(0),
                            items2[2], Date.valueOf(items2[3]));
                    authorService.updateAuthor(author);
                    Arrays.fill(items2,null);
                }catch (Exception e ){
                    System.out.println("Failed to run");
                }
                break;
            default:

        }
    }
    // end of run class


        // section main
        public static void main (String[]args) throws ParseException {
            while (flag == true) {
                System.out.println();
                System.out.print("Enter 'h' for help or press 'q' to quit : ");
                run();
            }
        }
//========================================================================
//way one
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = dateFormat.parse("1990-08-02");
//            java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
//            Date parsedDate = dateFormat.parse("1994-05-06");
//way two
//            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
//            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
// way three
//            System.out.println(Date.valueOf("1994-05-08"));
//===================================================================================

    }