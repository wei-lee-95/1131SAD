package com.service;
import org.springframework.stereotype.Service;

import com.dao.CustomizationOp;
import com.dao.CustomizationOpRepository;
import com.dao.OrderItem;
import com.dao.OrderItemRepository;

@Service
public class OrderItemService {
    private final OrderItemRepository OrderItemRepository;
    private CustomizationOpRepository CustomizationOptionRepository;

    public OrderItemService(OrderItemRepository OrderItemRepository) {
        this.OrderItemRepository = OrderItemRepository;
    }

    public OrderItem showOrderDetailByID(int OrderItemID){
        return OrderItemRepository.findById(OrderItemID).orElse(null);
    }

    public int addOrderItemPrice(int OrderItemID, int CustomizationOptionID){ //if 客製化選項被點擊，改單項商品總價錢
        int ItemPrice = OrderItemRepository.findById(OrderItemID).map(OrderItem -> OrderItem.getItemSubprice()).orElse(0);
        final int AdjustedPrice = CustomizationOptionRepository.findById(CustomizationOptionID).map(CustomizationOption -> CustomizationOption.getAdjustedPrice()).orElse(0);
        ItemPrice = ItemPrice + AdjustedPrice;
        return ItemPrice;
    }
    
}