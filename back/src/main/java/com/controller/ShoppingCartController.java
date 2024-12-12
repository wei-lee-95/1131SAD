package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.dao.CartItem;
import com.dao.CartItemRepository;
import com.service.MemberService;
import com.service.ShoppingCartService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private CartItemRepository cartItemRepository;

//加入購物車

    @PostMapping("/cart/{memberID}/{mealID}/{customization_ids}")
    public String addCartItem(@RequestBody int memberID, int mealID, List<Integer> customizationIDs) {

        shoppingCartService.addMealToCart(memberID, mealID, customizationIDs);
    
        return "success";
    }

    @GetMapping("/cart/{memberID}")
    public List<CartItem> getAllCartItems(){
        return cartItemRepository.findAll();
    }

    
}
