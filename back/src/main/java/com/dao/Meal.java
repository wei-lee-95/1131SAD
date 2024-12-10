package com.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "meal")

public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "meal_id")  // 映射到資料庫中的 meal_id 欄位
    private int mealID;

    @Column(name = "meal_name")
    private String name;

    @Column(name = "meal_type")
    private String type;

    @Column(name = "meal_description")
    private String description;

    @Column(name = "meal_price")
    private int price;

    @Column(name = "meal_photo")
    private String photo;

    public int getID(){
        return mealID;
    }
    public void setId(int id) {
        this.mealID = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
