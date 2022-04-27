package com.example.ERP.System.model;

import lombok.Data;

import javax.persistence.*;

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
    @Column(name = "cash")
    private String cash;
    @Column(name = "actual")
    private String actual;

    //    @MapsId(value = "stockId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id", insertable = false, updatable = false)
    private Stock stock;

    @Override
    public String toString() {
        return "Textile{" +
                "id=" + id +
                ", material='" + material + '\'' +
                ", quantity=" + quantity +
                ", cash='" + cash + '\'' +
                ", actual='" + actual + '\'' +
                '}';
    }

}
