package com.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository

public interface MealRepository extends JpaRepository<Meal, Integer>{

    
}
