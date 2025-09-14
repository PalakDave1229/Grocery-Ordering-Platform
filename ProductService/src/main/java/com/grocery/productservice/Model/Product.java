package com.grocery.productservice.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String Description;

    @Column(name = "unit")
    private String unit;    // e.g. "1kg", "500ml"

    @Column(name = "price")
    private int price;

    @Column(name = "shelf_life")
    private String shelfLife;

    @Column(name = "stock_quantity")
    private int stockQuantity;
}
