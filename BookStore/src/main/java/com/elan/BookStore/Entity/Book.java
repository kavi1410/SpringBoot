package com.elan.BookStore.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer Id;
    @Column(name = "name", nullable = false)
    String Name;
    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    String Description;
    @Column(name = "yearofpublication", nullable = false)
    Integer YearOfPublication;
    @Column(name = "booktype", nullable = false)
    String BookType;
    @Column(name = "price", nullable = false)
    double Price;
    @Column(name = "createdat", nullable = false)
    LocalDateTime CreatedAt;
    @Column(name = "updatedat", nullable = false)
    LocalDateTime UpdatedAt;

    @PrePersist
    public void DateprePersist() {

        if (CreatedAt == null) {
            this.setCreatedAt(LocalDateTime.now());
        }
        this.setUpdatedAt(LocalDateTime.now());

    }

}
