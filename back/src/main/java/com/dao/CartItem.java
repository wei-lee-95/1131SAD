package com.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cartitem")

public class CartItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "CartItem_id")  // 映射到資料庫中的欄位
    private int CartItem_id;

    @Column(name = "ShoppingCart_id")
    private int ShoppingCart_id;

    @Column(name = "meal_id")
    private int meal_id;

    @Column(name = "CartItem_quantity")
    private int quantity;

    @Column(name = "CartItem_itemsubprice")
    private int subprice;

    @Column(name = "customization_id")
    private int customiazation_id;
    //ok
    public int getCartItemID(){
        return CartItem_id;
    }
    public void setCartItemID(int id) {
        this.CartItem_id = id;
    }

    public int getCartID(){
        return ShoppingCart_id;
    }
    public void setCartID(int id) {
        this.ShoppingCart_id = id;
    }

    public int getMealID(){
        return meal_id;
    }
    public void setMealID(int id) {
        this.meal_id = id;
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

    public int getCustomizationID(){
        return customiazation_id;
    }
    public void setCustomizationID(int id) {
        this.customiazation_id = id;
    }

}
