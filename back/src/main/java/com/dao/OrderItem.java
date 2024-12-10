package com.dao;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "orderitem")

public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "OrderItem_id")
    private int item_id;

    @Column(name = "order_id")
    private int order_id;

    @Column(name = "meal_id")
    private int meal_id;

    @Column(name = "OrderItem_quantity")
    private int quantity;

    @Column(name = "OrderItem_itemsubprice")
    private int subprice;

    @Column(name = "customization_id")
    private int customization_id;

    //ok
    public int getOderItemID(){
        return item_id;
    }
    public void setOrderItemID(int id) {
        this.item_id = id;
    }

    public int getOrderID(){
        return order_id;
    }
    public void setOrderID(int id) {
        this.order_id = id;
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
    public void setItemQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItemSubprice(){
        return subprice;
    }
    public void setItemSubprice(int price) {
        this.subprice = price;
    }

    public int getCustomizationID(){
        return customization_id;
    }
    public void setCustomizationID(int id) {
        this.customization_id = id;
    }
}
