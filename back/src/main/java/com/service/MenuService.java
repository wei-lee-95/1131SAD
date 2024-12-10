package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dao.Menu;
import com.dao.Meal;
import com.dao.MealRepository;

@Service
public class MenuService {
    
    private final MealRepository mealRepository;

    public MenuService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public Menu getMenu() {
        List<Meal> meals = mealRepository.findAll();
        return new Menu(meals);         
    }

    public Menu getSelectMenu(String type) {
        List<Meal> meals = mealRepository.findByType(type);
        return new Menu(meals);         
    }
}
