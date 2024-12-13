package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Integer>{
    
    List<Meal> findByType(String type); // 查詢 category 為特定值的所有 Meal
    List<Meal> findByPrice(Integer price);
    
}
