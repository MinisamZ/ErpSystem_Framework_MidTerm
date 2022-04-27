package com.example.ERP.System.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.time.Instant;


@Data
@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Lob
    @Column(name = "material", nullable = false)
    private String material;
    @Column(name = "quantity", nullable = false)
    private Long quantity;
    @Column(name = "cash", nullable = false)
    private Long cash;
    @Column(name = "actual", nullable = false)
    private Date actual;

}