package com.microservices.orderservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Table
@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private String orderNumber;

    @OneToMany(mappedBy = "order")
    private List<OrderLineItem> orderLineItems;
}
