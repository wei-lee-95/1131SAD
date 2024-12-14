package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.dao.CartItem;
import com.dao.CartItemRepository;
import com.dao.Menu;
import com.dao.OrderRepository;
import com.dao.ShoppingCart;
import com.service.MemberService;
import com.service.OrderService;
import com.service.ShoppingCartService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private OrderService orderService;

    @GetMapping("/cart/{memberID}")
    public List<CartItem> showCart(@PathVariable int memberID){
        //shoppingCartService.newCart(memberID);
        return shoppingCartService.getCart(memberID);
    }

    @PostMapping("/cart/addMeal") //新增品項至購物車
    public String addCartItem(@RequestBody Map<String, Object> requestBody) {
        int memberID = (int) requestBody.get("memberID");
        int mealID = (int) requestBody.get("mealID");
        List<Integer> customizationIDs = (List<Integer>) requestBody.get("customizationIDs");

        shoppingCartService.addMealToCart(memberID, mealID, customizationIDs);
    
        return "success";
    }

    //從購物車內刪除品項

    @PostMapping("/cart/deleteMeal")
    public String deleteCartItem(@RequestBody Map<String, Object> requestBody) {
        int memberID = (int) requestBody.get("memberID");
        int mealID = (int) requestBody.get("mealID");
        List<Integer> customizationIDs = (List<Integer>) requestBody.get("customizationIDs");

        shoppingCartService.deleteMealToCart(memberID, mealID, customizationIDs);
    
        return "success";
    }

    //送出訂單 先新增order 再新增orderitem
    @PostMapping("/cart/addOrder") 
    public String addOrder(@RequestBody Map<String, Object> requestBody) {
        int memberID = (int) requestBody.get("memberID");
        //int mealID = (int) requestBody.get("mealID");
        //List<Integer> customizationIDs = (List<Integer>) requestBody.get("customizationIDs");

        orderService.createOrder(memberID);
        
        return "已送出訂單";
    }

    
}
