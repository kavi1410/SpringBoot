package com.elan.BookStore.Entity;

import com.elan.BookStore.Enum.Constant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;
    String name;
    @Column(name = "username")
    String userName;
    @Column(name = "emailid")
    String emailID;
    @Column(name = "password")
    String password;
    @Column(name = "isactive")
    Boolean isActive=true;
    @Column(name = "createdat")
    LocalDateTime createdAt;
    @Column(name = "updatedat")
    LocalDateTime updatedAt;
    @Column(name = "lastlogin")
    LocalDateTime lastLogin;
    String role= Constant.userType.Normal.value;


    @PrePersist
    public void DateTime(){
        if(createdAt == null){
            setCreatedAt(LocalDateTime.now());
        }

        setUpdatedAt(LocalDateTime.now());
        setLastLogin(LocalDateTime.now());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getUserName() {
        return userName;
    }
}