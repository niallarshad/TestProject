package com.example.demo.model;

public class Book {
    private String id;
    private String author;
    private String name;

    public Book() {
    }

    public Book(String id, String author, String name) {
        this.id = id;
        this.author = author;
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
