package com.twu.biblioteca.Model;

public class Book {
    private String title;
    private AuthorList authors;
    private int yearPublished;

    public Book(String title, AuthorList authors, int yearPublished) {
        this.title = title;
        this.authors = authors;
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorNames() {
        return authors.getAuthorNames();
    }

    public int getYearPublished() {
        return yearPublished;
    }
}
