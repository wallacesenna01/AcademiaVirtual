package com.wallace.artur.Academia.Virtual.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_usersimples")
public class UserSimple {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;

    public UserSimple(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    public UserSimple() {}

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserSimple that = (UserSimple) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
