package com.app.product.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="orders")
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_id")
    private Integer orderId;

    private String buyerEmail;

    private LocalDate orderedTime;

    private String products;

    private Double totalPrice;

}
