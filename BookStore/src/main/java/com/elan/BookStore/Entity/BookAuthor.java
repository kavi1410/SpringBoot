package com.elan.BookStore.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "bookauthor")
public class BookAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer Id;
    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id",nullable = false)
    Book book;
    @ManyToOne
    @JoinColumn(name = "author_id",referencedColumnName = "id",nullable = false)
    Author author;
}
