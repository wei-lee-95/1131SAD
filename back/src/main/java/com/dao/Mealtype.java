package com.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mealtype_custom")

public class Mealtype {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "meal_type")  // 映射到資料庫中的欄位
    private String type;

    @Column(name = "customization_id")
    private int customiazation_id;

//ok
    public String getType(){
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getCustom_ID(){
        return customiazation_id;
    }
    public void setCustom_ID(int id) {
        this.customiazation_id = id;
    }


    
}
