package org.example.repository;
import org.example.model.Author;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// if coonection was null
// char in prepare statement
// private query
public class AuthorRepository {

    // initialize variables
    private static final String queryBuildAuthor = "INSERT INTO author(author_first_name ," +
            "author_last_name, gender , phone_number , birthdate_author ) values (?,?,?,?,?)";
    private static final String queryDeleteAuthor = "delete from author where id = ?";
    private static final String queryUpdateAuthor = "update author set author_first_name = ? , author_last_name = ? , gender = ? , phone_number = ? , birthdate_author = ? where id = ? ";


    //section build author
    public void buildAuthor(Author author){
        try{
            Connection connect = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement = connect.prepareStatement(queryBuildAuthor);
            preparedStatement.setString(1,author.getAuthorFirstName());
            preparedStatement.setString(2,author.getAuthorLastName());
            preparedStatement.setString(3, String.valueOf(author.getGender()));
            preparedStatement.setString(4,author.getPhoneNumber());
            preparedStatement.setDate(5,author.getBirthdateWriter());
            preparedStatement.execute();
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Failed to execute query  !! ");
        }
    }



    //section delete author
    public void deleteAuthor(Author author){
        try {
            Connection connect = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement = connect.prepareStatement(queryDeleteAuthor);
            preparedStatement.setInt(1,author.getId());
            preparedStatement.execute();
            preparedStatement.close();
        }catch (Exception e){
            System.out.println("Failed to execute query  !! ");
        }

    }

//    author_first_name author_last_name , gender ,phone_number , birthday_author where id = ? ";
    //section update author
    public void updateAuthor(Author author) throws SQLException {
       try{
           Connection connect = ConnectionDatabase.getConnection();
           PreparedStatement preparedStatement = connect.prepareStatement(queryUpdateAuthor);
           preparedStatement.setString(1,author.getAuthorFirstName());
           preparedStatement.setString(2,author.getAuthorLastName());
           preparedStatement.setString(3,String.valueOf(author.getGender()));
           preparedStatement.setString(4,author.getPhoneNumber());
           preparedStatement.setDate(5,author.getBirthdateWriter());
           preparedStatement.setInt(6,author.getId());
           preparedStatement.execute();
           preparedStatement.close();
       }catch (Exception e ){
           System.out.println("Failed to execute query  !! ");
       }
    }





    public Author findByIdWriter(int id){
        return null;
    }

}
