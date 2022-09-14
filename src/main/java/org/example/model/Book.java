package org.example.model;

public class Book {
    private int page ;
    private String name ;
    private String author;

    public Book(int page, String name, String author) {
        this.page = page;
        this.name = name;
        this.author = author;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
