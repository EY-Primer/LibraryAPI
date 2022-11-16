package com.revature.repos;

import com.revature.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepoSpring extends JpaRepository<Book, Integer> {



}
