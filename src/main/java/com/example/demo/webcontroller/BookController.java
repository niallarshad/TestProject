package com.example.demo.webcontroller;

import com.example.demo.model.Book;
import com.example.demo.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/api/v1/books")
    public Book createBook(@RequestBody Book book) {
        log.info("person {}", book);
        book = bookService.createBook(book);
        return book;
    }

    @GetMapping("/api/v1/books")
    public Book getBook() {
        return bookService.getBook();
    }

    @PutMapping("/api/v1/books/{id}")
    public Book updateBook(@PathVariable(value = "id") String id,
                             @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }
}
