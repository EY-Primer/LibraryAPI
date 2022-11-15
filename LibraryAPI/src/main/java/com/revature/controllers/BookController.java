package com.revature.controllers;

import com.revature.models.Book;
import com.revature.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //This annotation combines @Controller and @ResponseBody
//so this class is now a Bean that can use MVC annotations and send JSON in HTTP Responses
@RequestMapping(value="/books") //all requests ending in /library/books will go to this controller.
@CrossOrigin //This lets us take in HTTP requests from other origins (you may need to configure this later)
public class BookController {

    private BookRepo br;

    @Autowired
    public BookController(BookRepo br){
        super();
        this.br = br;
    }

    //TODO: leave this one implemented for reference?
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {

        List<Book> books = br.getAllBooks();

        if(books != null){
            return ResponseEntity.ok().body(books);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Book> insertNewBook(@RequestBody Book book){

        Book b = br.insertBook(book);

        if(b!=null){
            return ResponseEntity.accepted().body(b);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    //fixed the compilation error by making the paths more unique
    //before there were essentially two get mappings with /id
    //so the destination of a GET request ending in an int would be ambiguous

    @GetMapping(value="/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {

        Book b = br.getBookById(id);

        if(b!=null){
            return ResponseEntity.accepted().body(b);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping(value="author/{id}")
    public ResponseEntity<List<Book>> getBooksByAuthorId(@PathVariable int id) {

        List<Book> books = br.getBooksByAuthorId(id);

        if(books != null) {
            return ResponseEntity.ok().body(books);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

}

