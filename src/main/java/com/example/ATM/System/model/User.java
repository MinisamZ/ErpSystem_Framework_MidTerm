package com.example.ATM.System.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "сard_number")
    private String cardNumber;
    @Column(name = "password")
    private String password;
    @Column(name = "card_expiry_date")
    private String cardExpiryDate;
    @Column(name = "cvv")
    private String CVV;
}
