package com.work.e_commerce.service;

import com.work.e_commerce.converter.DtoConverter;
import com.work.e_commerce.dto.OrderResponse;
import com.work.e_commerce.entity.Order;
import com.work.e_commerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }




    @Override
    public List<OrderResponse> findAll() {
        List<Order> orders = orderRepository.findAll();
        return DtoConverter.convertToOrderResponseList(orders);
    }

    @Override
    public Order findById(long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if(optionalOrder.isEmpty()){
            return optionalOrder.get();
        }
        return null;
    }

    @Override
    public OrderResponse save(Order order) {
        return DtoConverter.convertToOrderResponse(orderRepository.save(order));
    }

    @Override
    public OrderResponse update(Order order) {
        Order updatedOrder = orderRepository.save(order);
        return new OrderResponse(updatedOrder.getId(), updatedOrder.getProductId(), updatedOrder.getCount(), updatedOrder.getUserId(), updatedOrder.getAddressId());
    }

    @Override
    public OrderResponse deleteById(long id) {
        Order willremove = findById(id);
        orderRepository.delete(willremove);
        return DtoConverter.convertToOrderResponse(willremove);
    }
}
