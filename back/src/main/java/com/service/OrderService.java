package com.service;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CartItem;
import com.dao.Order;
import com.dao.OrderItem;
import com.dao.OrderRepository;

import jakarta.transaction.Transactional;

import com.dao.OrderItemRepository;
import com.dao.CartItemRepository;

@Service
public class OrderService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;
    
    @Transactional
    public void createOrder(int memberID, String comment) {
        
        // 計算該會員的所有 cart_item 的 subprice 總和
        Integer totalSubprice = cartItemRepository.calculateTotalSubpriceByMemberId(memberID);

        Order order = new Order();
        order.setMemberID(memberID);
        order.setOrderTime(LocalDateTime.now());
        order.setStatus("餐點製作中...");
        order.setOrderPrice(totalSubprice);
        order.setComment(comment);
        order = orderRepository.save(order);

        int orderId = order.getOrderID(); 

        List<CartItem> cartItems = cartItemRepository.findByMemberID(memberID);
        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderID(orderId);
            orderItem.setMealID(cartItem.getMealID());
            orderItem.setItemQuantity(cartItem.getItemQuantity());
            orderItem.setItemSubprice(cartItem.getItemSubprice());
            orderItem.setCustomizationIDs(cartItem.getCustomizationIDs());

            orderItemRepository.save(orderItem);
        }

        // 4. 刪除 CartItem
        
        cartItemRepository.deleteByMemberID(memberID);

    } 
}