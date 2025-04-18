package com.wallace.artur.Academia.Virtual.User;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@Table(name = "auth_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String email;
    private String password;

    @CreatedDate
    private LocalDate createAt;

    public User(Long id, String name, String email, String password, LocalDate createAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createAt = createAt;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }
}
