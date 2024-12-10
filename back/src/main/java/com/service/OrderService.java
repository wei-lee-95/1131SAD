package com.service;
import org.springframework.stereotype.Service;

import com.dao.Order;
import com.dao.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository OrderRepository;

    public OrderService(OrderRepository OrderRepository) {
        this.OrderRepository = OrderRepository;
    }

    public Order showOrderDetailByID(int OrderID){ 
        return OrderRepository.findById(OrderID).orElse(null);
    }
    
}