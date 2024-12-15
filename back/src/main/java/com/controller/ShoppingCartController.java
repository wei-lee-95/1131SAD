package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.dao.CartItem;
import com.service.OrderService;
import com.service.ShoppingCartService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/cart/{memberID}")
    public List<CartItem> showCart(@PathVariable int memberID){
        
            return shoppingCartService.getCart(memberID);
    
    }

    @PostMapping("/cart/addMeal") //新增品項至購物車
    public String addCartItem(@RequestBody Map<String, Object> requestBody) {
        int memberID = (int) requestBody.get("memberID");
        int mealID = (int) requestBody.get("mealID");
        Object customizationIDsObject = requestBody.get("customizationIDs");
        List<Integer> customizationIDs;

        if (customizationIDsObject instanceof List) {
            customizationIDs = ((List<?>) customizationIDsObject)
                .stream()
                .map(id -> (Integer) id) // 確保類型為 Integer
                .collect(Collectors.toList());
        } else {
            customizationIDs = new ArrayList<>(); // 如果不是 List，默認空
        }
        int quantity = (int) requestBody.get("quantity");

        shoppingCartService.addMealToCart(memberID, mealID, quantity, customizationIDs);
    
        return "success";
    }
    @PostMapping("/cart/updateMealQuantity")
    public String updateMealQuantity(@RequestBody Map<String, Object> requestBody) {
        System.out.println("RequestBody: " + requestBody);
        int memberID = (int) requestBody.get("memberID");
        int mealID = (int) requestBody.get("mealID");
        // 強制檢查 customizationIDs 類型
        // 獲取 customizationIDs，並檢查其是否為 ArrayList
        Object customizationIDsObject = requestBody.get("customizationIDs");
        List<Integer> customizationIDs;

        if (customizationIDsObject instanceof List) {
            customizationIDs = ((List<?>) customizationIDsObject)
                .stream()
                .map(id -> (Integer) id) // 確保類型為 Integer
                .collect(Collectors.toList());
        } else {
            customizationIDs = new ArrayList<>(); // 如果不是 List，默認空
        }
        int newQuantity = (int) requestBody.get("newQuantity");

        try {
            shoppingCartService.updateMealQuantityInCart(memberID, mealID, newQuantity, customizationIDs);
            return "Quantity updated successfully";
        } catch (RuntimeException e) {
            // 如果更新失敗，返回錯誤信息
            return "Error: " + e.getMessage();
        }
    }


    //從購物車內刪除品項

    @PostMapping("/cart/deleteMeal")
    public String deleteCartItem(@RequestBody Map<String, Object> requestBody) {
        int memberID = (int) requestBody.get("memberID");
        int mealID = (int) requestBody.get("mealID");
        List<Integer> customizationIDs = (List<Integer>) requestBody.get("customizationIDs");
        if (customizationIDs == null) {
            customizationIDs = new ArrayList<>(); // 設為空的 ArrayList
        }

        shoppingCartService.deleteMealToCart(memberID, mealID, customizationIDs);
    
        return "success";
    }

    //送出訂單 先新增order 再新增orderitem
    @PostMapping("/cart/addOrder") 
    public String addOrder(@RequestBody Map<String, Object> requestBody) {
        int memberID = (int) requestBody.get("memberID");
        String comment = (String)requestBody.get("comment");
        //int mealID = (int) requestBody.get("mealID");
        //List<Integer> customizationIDs = (List<Integer>) requestBody.get("customizationIDs");

        if (comment == null) {
            System.out.println("Comment is null!");
        } else {
            System.out.println("Comment: " + comment);
        }

        orderService.createOrder(memberID, comment);
        
        return "已送出訂單";
    }

    
}
