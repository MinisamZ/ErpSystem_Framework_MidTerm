package com.example.ERP.System.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "login", nullable = false)
    private String login;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "country")
    private String country;
    @Column(name = "gender")
    private String gender;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "reg_date")
    private LocalDateTime regDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private RoleEnum role;


}

