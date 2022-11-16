package com.revature.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Component
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int bookId;

    @Column (name = "book_title")
    private String title;

    @Column
    private boolean isStocked;

    //had to change CascadeType to MERGE in order for insert to work in Spring
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.MERGE)
    @JoinColumn (name = "author_id_fk")
    public Author authorFk;


    //Boilerplate code below------------------------------


    public Book() {
    }

    public Book(int bookId, String title, boolean isStocked, Author authorFk) {
        this.bookId = bookId;
        this.title = title;
        this.isStocked = isStocked;
        this.authorFk = authorFk;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getIsStocked() {
        return isStocked;
    }

    public void setIsStocked(boolean stocked) {
        isStocked = stocked;
    }

    public Author getAuthorFk() {
        return authorFk;
    }

    public void setAuthorFk(Author authorFk) {
        this.authorFk = authorFk;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", isStocked=" + isStocked +
                ", authorFk=" + authorFk +
                '}';
    }
}

