package com.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "customizationop")

public class CustomizationOp {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "customization_id")
    private int customiazation_id;

    @Column(name = "customization_name")
    private String name;

    @Column(name = "customization_adjustedprice")
    private int adjustedprice;
//ok
    public int getCustomizationID(){
        return customiazation_id;
    }
    public void setCustomizationID(int id) {
        this.customiazation_id = id;
    }

    public String getCustomizationName(){
        return name;
    }
    public void setCustomizationName(String name) {
        this.name = name;
    }
    
    public int getAdjustedPrice(){
        return adjustedprice;
    }
    public void setAdjustedPrice(int price) {
        this.adjustedprice = price;
    }
}
