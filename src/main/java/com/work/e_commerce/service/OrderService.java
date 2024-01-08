package com.work.e_commerce.service;

import com.work.e_commerce.dto.OrderResponse;
import com.work.e_commerce.entity.Order;

import java.util.List;

public interface OrderService {
    List<OrderResponse> findAll();

    Order findById(long id);

    OrderResponse save(Order order);

    OrderResponse update(Order order);
    OrderResponse deleteById(long id);
}
