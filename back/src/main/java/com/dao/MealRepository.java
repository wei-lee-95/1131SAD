package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MealRepository extends JpaRepository<Meal, Integer>{
    
    List<Meal> findByType(String type); // 查詢 category 為特定值的所有 Meal
    
}
