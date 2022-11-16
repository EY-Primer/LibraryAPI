package com.revature.controllers;

import com.revature.models.Book;
import com.revature.repos.BookRepo;
import com.revature.repos.BookRepoSpring;
import org.apache.coyote.Response;
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

    private BookRepoSpring brs;

    @Autowired
    public BookController(BookRepoSpring brs){
        super();
        this.brs = brs;
    }

    //TODO: leave this one implemented for reference?
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {

        List<Book> books = brs.findAll(); //this is now using a method from JpaRepository (Spring Data)

        if(books != null){
            return ResponseEntity.ok().body(books);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Book> insertNewBook(@RequestBody Book book){

        Book b = brs.save(book);

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

        //findById from JpaRepository returns an optional! So we must call .get() to get the data
        Book b = brs.findById(id).get();

        if(b!=null){
            return ResponseEntity.accepted().body(b);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping(value="author/{id}")
    public ResponseEntity<List<Book>> getBooksByAuthorId(@PathVariable int id) {

        List<Book> books = brs.findBookByAuthorFk(id);

        if(books != null) {
            return ResponseEntity.ok().body(books);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Book> toggleIsStocked(@PathVariable int id){

        Book book = brs.findById(id).get();

        boolean newStatus = !book.getIsStocked();

        //set isStocked to the opposite of its current value
        book.setIsStocked(newStatus);

        brs.save(book);

        return ResponseEntity.accepted().body(book);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteBook(@PathVariable int id){

        Book bookToDelete = brs.findById(id).get();

        if(bookToDelete != null) {
            brs.delete(bookToDelete);
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}

