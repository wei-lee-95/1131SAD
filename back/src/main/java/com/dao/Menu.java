package com.dao;

import java.util.List;

public class Menu {

    private List<Meal> meals;

    public Menu(List<Meal> meals) {
        this.meals = meals;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}
