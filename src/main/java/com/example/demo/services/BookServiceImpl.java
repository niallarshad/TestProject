package com.example.demo.services;

import com.example.demo.Constants;
import com.example.demo.model.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.*;
import java.util.Random;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    String path = Constants.livePath;
    ObjectMapper om = new ObjectMapper();

    @Override
    public Book createBook(Book book) {
        String personStr;
        try {
            personStr = om.writeValueAsString(book);
            log.info(personStr);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        if (book.getId().isEmpty()) {
            Random rn = new Random();
            book.setId(Integer.toString(rn.nextInt(100) + 1));
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.write(personStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public Book getBook() {
        Book book;
        try {
            book = om.readValue(new File(path), Book.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    @Override
    public Book updateBook(String id, Book book) {
        Book oldBook;
        // Fetch person from database
        try {
            oldBook = om.readValue(new File(path), Book.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String personStr;

        // if person id is the same as id of person fetched from database then update the person
        if(oldBook.getId().equalsIgnoreCase(id)) {
            book.setId(id);
            try {
                personStr = om.writeValueAsString(book);
                log.info(personStr);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
                out.write(personStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Person not found"
            );
        }
        return book;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
