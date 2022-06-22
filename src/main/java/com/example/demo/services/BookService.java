package com.example.demo.services;

import com.example.demo.model.Book;

public interface BookService {

    Book createBook(Book book);


    Book getBook();

    Book updateBook(String id, Book book);

}
