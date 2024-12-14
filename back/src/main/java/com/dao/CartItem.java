package com.dao;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "cartitem")

public class CartItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "cart_item_id")  // 映射到資料庫中的欄位
    private int CartItem_id;

    @Column(name = "meal_id")
    private int meal_id;

    @Column(name = "member_id")
    private int member_id;

    @Column(name = "cart_item_quantity")
    private int quantity;

    @Column(name = "cart_item_itemsubprice")
    private int subprice;

    @Column(name = "customization_ids")
    private String customization_ids;


    @Transient // 如果不需要持久化，可以加上 @Transient
    private Meal meal;  // 餐點資料

    @Transient
    private List<CustomizationOption> customizations;  // 自定義選項資料

    // getters and setters

    // meal getter and setter
    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    // customizations getter and setter
    public List<CustomizationOption> getCustomizations() {
        return customizations;
    }

    public void setCustomizations(List<CustomizationOption> customizations) {
        this.customizations = customizations;
    }
    //ok
    public int getCartItemID(){
        return CartItem_id;
    }
    public void setCartItemID(int id) {
        this.CartItem_id = id;
    }

    public int getMealID(){
        return meal_id;
    }
    public void setMealID(int id) {
        this.meal_id = id;
    }

    public int getMemberID(){
        return member_id;
    }
    public void setMemberID(int id) {
        this.member_id = id;
    }

    public int getItemQuantity(){
        return quantity;
    }
    public void setItemQuantuty(int quantity) {
        this.quantity = quantity;
    }

    public int getItemSubprice(){
        return subprice;
    }
    public void setItemSubprice(int subprice) {
        this.subprice = subprice;
    }

    public String getCustomizationIDs(){
        return customization_ids;
    }
    public void setCustomizationIDs(String id) {
        this.customization_ids = id;
    }

}