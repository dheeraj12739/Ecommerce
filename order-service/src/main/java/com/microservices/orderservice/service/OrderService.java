package com.microservices.orderservice.service;

import com.microservices.orderservice.dto.OrderLineItemRequest;
import com.microservices.orderservice.dto.OrderRequest;
import com.microservices.orderservice.entity.Order;
import com.microservices.orderservice.entity.OrderLineItem;
import com.microservices.orderservice.repository.OrderLineItemRepository;
import com.microservices.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderLineItemRepository orderLineItemRepository;

    public void createOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(orderRequest.getOrderNumber());
        List<OrderLineItem> orderLineItemList = new ArrayList<>();
        for (OrderLineItemRequest orderLineItemRequest : orderRequest.getOrderLineItems()) {

            OrderLineItem orderLineItem = new OrderLineItem();
            orderLineItem.setPrice(orderLineItemRequest.getPrice());
            orderLineItem.setQuantity(orderLineItemRequest.getQuantity());
            orderLineItem.setSkuCode(orderLineItemRequest.getSkuCode());
            orderLineItemList.add(orderLineItem);
        }
        order.setOrderLineItems(orderLineItemList);
        orderRepository.save(order);
    }
}
