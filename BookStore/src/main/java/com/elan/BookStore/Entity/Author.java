package com.elan.BookStore.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Integer Id;
    @Column(name = "name")
    String Name;
    @Column(name = "gender")
    String Gender;
    @Column(name = "genre")
    String Genre;
    @Column(name = "createdat")
    LocalDateTime CreatedAt;
    @Column(name = "updatedat")
    LocalDateTime UpdatedAt;

    @PrePersist
    public void DateprePersist() {

        if (CreatedAt == null) {
            this.setCreatedAt(LocalDateTime.now());
        }
        this.setUpdatedAt(LocalDateTime.now());

    }
}
