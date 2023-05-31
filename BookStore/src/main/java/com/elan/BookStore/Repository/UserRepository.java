package com.elan.BookStore.Repository;

import com.elan.BookStore.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByuserNameAndPassword(String userName, String password);

    Optional<User> findByuserName(Object userName);
}
