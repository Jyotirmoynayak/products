package com.app.product.entities;

import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name="product")
@Data
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="product_id")
    private Integer productId;

    private String name;

    private Double price;
}
