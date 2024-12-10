package com.service;
import org.springframework.stereotype.Service;

import com.dao.ShoppingCart;
import com.dao.ShoppingCartRepository;
import com.dao.CustomizationOp;
import com.dao.CustomizationOpRepository;
import com.dao.OrderItem;
import com.dao.OrderItemRepository;

@Service
public class ShoppingCartService {
    private ShoppingCartRepository ShoppingCartRepository;
    //private OrderItemRepository OrderItemRepository;
    //private CustomizationOpRepository CustomizationOpRepository;

    public ShoppingCartService(ShoppingCartRepository ShoppingCartRepository) {
        this.ShoppingCartRepository = ShoppingCartRepository;
    }

    public ShoppingCart showOrderDetailByID(int OrderItemID){
        return ShoppingCartRepository.findById(OrderItemID).orElse(null);
    }
    
    
}