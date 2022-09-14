package org.example.service;

import org.example.model.Author;
import org.example.repository.AuthorRepository;

import java.sql.SQLException;


public class AuthorService {

    private static AuthorRepository authorRepository = new AuthorRepository();
    public static void buildAuthor(Author author){
        authorRepository.buildAuthor(author);
    }
    public static void deleteAuthor(Author author){
        authorRepository.deleteAuthor(author);
    }
    public static void updateAuthor(Author author) throws SQLException {
        authorRepository.updateAuthor(author);
    }
}
