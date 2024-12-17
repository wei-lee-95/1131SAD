package com.service;
import org.springframework.stereotype.Service;


import com.dao.OrderItem;
import com.dao.OrderItemRepository;

@Service
public class OrderItemService {
    private final OrderItemRepository OrderItemRepository;
    

    public OrderItemService(OrderItemRepository OrderItemRepository) {
        this.OrderItemRepository = OrderItemRepository;
    }

    // public OrderItem showOrderDetailByID(int OrderItemID){
    //     return OrderItemRepository.findById(OrderItemID).orElse(null);
    // }
    
}
