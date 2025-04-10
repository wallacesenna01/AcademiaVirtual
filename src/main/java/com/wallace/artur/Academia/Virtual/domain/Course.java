package com.wallace.artur.Academia.Virtual.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String category;
    private LocalDateTime createAt;

    public Course(String name, String description, String category, LocalDateTime createAt) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.createAt = createAt;
    }

    public Course() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
