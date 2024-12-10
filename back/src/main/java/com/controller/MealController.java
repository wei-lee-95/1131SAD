package com.controller;

import org.springframework.web.bind.annotation.RestController;

import com.dao.Member;
import com.dao.Meal;
import com.dao.Menu;

import com.service.MemberService;
import com.service.MealService;
import com.service.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MealController {
    
    // @Autowired
    // private MemberService memberService;

    @Autowired
    private MealService mealService;

    @Autowired
    private MenuService menuService;

    @GetMapping("/member/{memberID}")
    public Menu showMenu(@PathVariable int memberID){
        return menuService.getMenu();
    }

    @GetMapping("/member/{memberID}/{mealType}")
    public Menu showSelectMenu(@PathVariable String mealType){
        return menuService.getSelectMenu(mealType);
    }

    @GetMapping("/member/{memberID}/meal/{mealID}")
    public Meal showMealDetail(@PathVariable int mealID){
        return mealService.showMealDetailByID(mealID);
    }
    
    
}
