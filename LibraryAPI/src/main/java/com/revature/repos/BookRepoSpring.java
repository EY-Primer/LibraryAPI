package com.revature.repos;

import com.revature.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepoSpring extends JpaRepository<Book, Integer> {



}
