package com.example.ERP.System.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "textile")
public class Textile {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "material")
    private String material;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "address")
    private String address;
    @Column(name = "cash")
    private String cash;
    @Column(name = "actual")
    private String actual;

}
