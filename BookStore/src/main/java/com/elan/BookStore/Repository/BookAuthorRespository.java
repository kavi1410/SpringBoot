package com.elan.BookStore.Repository;

import com.elan.BookStore.Entity.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookAuthorRespository extends JpaRepository<BookAuthor,Integer> {
    List<BookAuthor> findAllBybookId(Integer id);
}
