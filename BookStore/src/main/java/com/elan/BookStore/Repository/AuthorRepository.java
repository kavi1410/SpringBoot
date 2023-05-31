package com.elan.BookStore.Repository;

import com.elan.BookStore.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
