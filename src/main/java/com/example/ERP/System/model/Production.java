package com.example.ERP.System.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "production")
public class Production {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;
    @Lob
    @Column(name = "material", nullable = false)
    private String material;
    @Column(name = "quantity", nullable = false)
    private Long quantity;
    @Column(name = "actual", nullable = false)
    private String actual;

}