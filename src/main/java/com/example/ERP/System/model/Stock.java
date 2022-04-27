package com.example.ERP.System.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "stocks")
public class Stock {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "stock", fetch = FetchType.LAZY)
    private List<Textile> textileList;

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", textileList=" + textileList +
                '}';
    }
}
