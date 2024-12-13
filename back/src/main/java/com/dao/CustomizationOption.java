package com.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customizationoption")

public class CustomizationOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "customization_id")  // 映射到資料庫中的 memberID 欄位
    private int customizationID;

    @Column(name = "customization_name")
    private String name;

    @Column(name = "customization_adjustedprice")
    private int adjustedprice;

    public int getID(){
        return customizationID;
    }

    public void setId(int id) {
        this.customizationID = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAdjustedPrice(){
        return adjustedprice;
    }

    public void setAdjustedPrice(int adjustedprice) {
        this.adjustedprice = adjustedprice;
    }
    
}
