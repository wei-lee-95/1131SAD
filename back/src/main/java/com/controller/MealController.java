package com.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.HashMap;
import java.util.List;


import com.dao.Meal;
import com.dao.Menu;
import com.dao.CustomizationOption;


import com.service.CustomizationOptionService;
import com.service.MealService;
import com.service.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class MealController {
    
    // @Autowired
    // private MemberService memberService;

    @Autowired
    private MealService mealService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private CustomizationOptionService customizationOptionService;


    @GetMapping("/member/{memberID}")
    public Menu showMenu(@PathVariable int memberID){
        //shoppingCartService.newCart(memberID);
        return menuService.getMenu();
    }

    @GetMapping("/member/{memberID}/{mealType}")
    public Menu showSelectMenu(@PathVariable String mealType){
        return menuService.getSelectMenu(mealType);

    }

    @GetMapping("/member/{memberID}/meal/{mealID}")
    public Map<String, Object> showMealDetailWithCustomization(@PathVariable int mealID) {
        // 獲取餐點詳細資料
        Meal meal = mealService.showMealDetailByID(mealID);
        
        // 獲取餐點的自訂選項
        List<CustomizationOption> customizationOptions = customizationOptionService.getOption(mealID);
        
        // 創建返回的 Map，包含餐點和自訂選項
        Map<String, Object> response = new HashMap<>();
        response.put("meal", meal);
        response.put("customizationOptions", customizationOptions);
        
        return response;
    }

    @GetMapping("/member/{memberID}/meal/{mealID}/price")//點擊新增刪除客製化選項時重新計算價格
    public int getMealPrice(
        @PathVariable int mealID, 
        @RequestParam List<Integer> customization_ids) {
    // 呼叫 getCustomizationPrice 方法計算總價
    return customizationOptionService.getCustomizationPrice(mealID, customization_ids);
    }
}
