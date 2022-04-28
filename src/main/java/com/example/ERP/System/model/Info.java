package com.example.ERP.System.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "info")
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "budget", nullable = false)
    private Long budget;

    @Column(name = "income", nullable = false)
    private Long income;

    @Column(name = "costs", nullable = false)
    private Long costs;

    @Column(name = "actual", nullable = false)
    private String actual;


}