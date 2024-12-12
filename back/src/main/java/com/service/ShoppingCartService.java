package com.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.dao.ShoppingCart;
import com.dao.ShoppingCartRepository;

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
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CustomizationOptionRepository customizationOptionRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private CustomizationOptionService customizationOptionService;


    public ShoppingCartService(ShoppingCartRepository ShoppingCartRepository) {
        this.shoppingCartRepository = ShoppingCartRepository;
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

    public void addMealToCart(int memberID, int mealID, List<Integer> customizationIDs) {
    
        int itemSubprice = customizationOptionService.getCustomizationPrice(mealID, customizationIDs);
        // 將 List<Integer> 轉換為逗號分隔的 String
        String customizationIDsString = customizationIDs.stream()
                                                        .map(String::valueOf)
                                                        .collect(Collectors.joining(","));

        CartItem cartItem = new CartItem();
        cartItem.setMealID(mealID);
        cartItem.setMemberID(memberID);
        cartItem.setItemQuantuty(1);
        cartItem.setCustomizationIDs(customizationIDsString);
        cartItem.setItemSubprice(itemSubprice);

        cartItemRepository.save(cartItem);
    } 

    @Transactional
    public void deleteMealToCart(int memberID, int mealID, List<Integer> customizationIDs) {
    
        // 將 List<Integer> 轉換為逗號分隔的 String
        String customizationIDsString = customizationIDs.stream()
                                                        .map(String::valueOf)
                                                        .collect(Collectors.joining(","));
                                        
        cartItemRepository.deleteByMealIDAndCustomizationIDs(mealID, customizationIDsString);
    } 
}