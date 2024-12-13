package com.service;
import com.dao.Meal;

import com.dao.MealRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    public Meal showMealDetailByID(int mealID){ //點擊品項後跳出一個框框顯示詳細資料（詳細敘述，價格）
        return mealRepository.findById(mealID).orElse(null); //給前端決定要show哪些
    }


}
