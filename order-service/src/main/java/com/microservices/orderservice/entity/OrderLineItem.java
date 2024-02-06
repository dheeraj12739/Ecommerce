package com.microservices.orderservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Table
@Entity
public class OrderLineItem {

    @Id
    @GeneratedValue
    private Long id;

    private String skuCode;

    private Integer quantity;

    private Double price;


}
