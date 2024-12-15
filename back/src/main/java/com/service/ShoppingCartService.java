package com.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;

import com.dao.CustomizationOption;
import com.dao.CustomizationOptionRepository;
import com.dao.Meal;
import com.dao.MealRepository;
import com.dao.CartItem;
import com.dao.CartItemRepository;

@Service
public class ShoppingCartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CustomizationOptionRepository customizationOptionRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private CustomizationOptionService customizationOptionService;


    public List<CartItem> getCart(int memberID) {
        List<CartItem> cartItems = cartItemRepository.findByMemberID(memberID);
        for (CartItem cartItem : cartItems) {

            // 根據 meal_id 查詢餐點
            Meal meal = mealRepository.findById(cartItem.getMealID()).orElse(null);

            String customizationIdsString = cartItem.getCustomizationIDs();
            List<Integer> customizationIds = new ArrayList<>();
            if (customizationIdsString != null && !customizationIdsString.isEmpty()) {
                customizationIds = Arrays.stream(customizationIdsString.split(","))
                                         .map(Integer::parseInt)
                                         .collect(Collectors.toList());
            }
            
            // 根據 customization_ids 查詢自定義選項
            List<CustomizationOption> customizations = customizationOptionRepository.findBycustomizationIDIn(customizationIds);

            // 直接將 meal 和 customizations 加到 cartItem 中
            if (meal != null) {
                cartItem.setMeal(meal);  // 假設 CartItem 中有一個 meal 屬性
            }

            cartItem.setCustomizations(customizations);  // 假設 CartItem 中有一個 customizations 屬性
        }

        return cartItems;
    }
    

    //拿到meal_id, List<Integer> customization_ids 
    //meal_item = meal_id,
    //存進"Cart_item" table, return 新增成功

    // public void newCart(int memberID){
    //     ShoppingCart shoppingCart = new ShoppingCart();
    //     shoppingCart.setMemberID(memberID);
    //     shoppingCart.setPrice(0);

    //     //shoppingCart.addItem(shoppingCart);
    //     shoppingCartRepository.save(shoppingCart);

    // }

    public void addMealToCart(int memberID, int mealID, int newQuantity, List<Integer> customizationIDs) {
    
        int itemSubprice = customizationOptionService.getCustomizationPrice(mealID, customizationIDs);
        // 將 List<Integer> 轉換為逗號分隔的 String
        String customizationIDsString = customizationIDs.stream()
                                                        .map(String::valueOf)
                                                        .collect(Collectors.joining(","));

        CartItem cartItem = new CartItem();
        cartItem.setMealID(mealID);
        cartItem.setMemberID(memberID);
        cartItem.setItemQuantuty(newQuantity);
        cartItem.setCustomizationIDs(customizationIDsString);
        cartItem.setItemSubprice(itemSubprice * newQuantity);

        cartItemRepository.save(cartItem);
    } 

    @Transactional
    public void deleteMealToCart(int memberID, int mealID, List<Integer> customizationIDs) {
    
        // 將 List<Integer> 轉換為逗號分隔的 String
        String customizationIDsString = customizationIDs.stream()
                                                        .map(String::valueOf)
                                                        .collect(Collectors.joining(","));
                                        
        //cartItemRepository.deleteByMealIDAndCustomizationIDs(mealID, customizationIDsString); 

        // 查詢符合條件的所有記錄
        List<CartItem> cartItems = cartItemRepository.findTop1ByMemberIdAndMealIDAndCustomizationIDs(memberID, mealID, customizationIDsString);

        // 如果有記錄存在，刪除第一筆
        if (!cartItems.isEmpty()) {
            cartItemRepository.delete(cartItems.get(0));
        } else {
        // 如果沒有符合條件的記錄，拋出異常或打印警告
            throw new IllegalArgumentException("No matching cart item found for the given criteria.");
        }
    } 

    public void updateMealQuantityInCart(int memberId, int mealID, int newQuantity, List<Integer> customizationIDs) {
        // 1. 查詢購物車中是否已經存在該會員和餐點的 CartItem
        
        String customizationIDsString  = (customizationIDs == null || customizationIDs.isEmpty())
        ? ""
        : customizationIDs.stream()
                          .map(String::valueOf)
                          .collect(Collectors.joining(","));

        CartItem cartItem = cartItemRepository.findByMemberIdAndMealIDAndCustomizationIDs(memberId, mealID, customizationIDsString);
    
        if (cartItem != null) {
            // 2. 更新數量
            cartItem.setItemQuantuty(newQuantity);
    
            // 3. 計算更新後的價格，這里假設 itemSubprice 是根據自定義選項來計算的
            int itemSubprice = customizationOptionService.getCustomizationPrice(mealID, customizationIDs);
            cartItem.setItemSubprice(itemSubprice * newQuantity);  // 更新總價格
    
            // 4. 保存更新後的 CartItem
            cartItemRepository.save(cartItem);
        } else {
            // 如果沒有找到對應的 CartItem，可能需要報錯或做其他處理
            throw new IllegalArgumentException("Cart item not found for memberID: " + memberId + " and mealID: " + mealID);
        }
    }
    
}