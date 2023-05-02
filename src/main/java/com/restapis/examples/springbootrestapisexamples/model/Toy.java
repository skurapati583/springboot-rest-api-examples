package com.restapis.examples.springbootrestapisexamples.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "Toys")
public class Toy {

    @Id
    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_CATEGORY")
    private String productCategory;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "REMAINING_STOCK")
    private long remainingStock;

}
