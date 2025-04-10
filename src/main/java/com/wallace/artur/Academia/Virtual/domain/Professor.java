package com.wallace.artur.Academia.Virtual.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String phone;
    private String speciality;
    private LocalDate hireDate;
    private boolean active;
}
