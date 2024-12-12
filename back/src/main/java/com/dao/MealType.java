package com.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;


// MealType 实体类
@Entity
@Table(name = "mealtype_customization")

@IdClass(MealTypeId.class)  // 指定复合主键类
public class MealType {

    @Id
    @Column(name = "meal_type")
    private String type;

    @Id
    @Column(name = "customization_id")
    private int customization_id;

    // getter 和 setter 方法
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCustomization_id() {
        return customization_id;
    }

    public void setCustomization_id(int customization_id) {
        this.customization_id = customization_id;
    }
}