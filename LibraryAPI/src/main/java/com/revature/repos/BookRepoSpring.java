package com.revature.repos;

import com.revature.models.Author;
import com.revature.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepoSpring extends JpaRepository<Book, Integer> {

    List<Book> findBookByAuthorFk(int id);

}
