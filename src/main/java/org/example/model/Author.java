package org.example.model;

import java.sql.Date;

public class Author {
    private int id;
    private String authorFirstName;
    private String authorLastName;
    private char gender;
    private String phoneNumber;
    private Date birthdateWriter;

    public Author(int id){
        this.id = id;
    }

    public Author(int id ,String authorFirstName, String authorLastName, char gender, String phoneNumber, Date birthdateWriter) {
        this.id = id ;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.birthdateWriter = birthdateWriter;
    }
    public Author(String authorFirstName, String authorLastName, char gender, String phoneNumber, Date birthdateWriter) {
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.birthdateWriter = birthdateWriter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthdateWriter() {
        return birthdateWriter;
    }

    public void setBirthdateWriter(Date birthdateWriter) {
        this.birthdateWriter = birthdateWriter;
    }
}
