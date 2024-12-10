
package com.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "shoppingcart")

public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "ShoppingCart_id")
    private int cart_id;

    @Column(name = "member_id")
    private int member_id;

    @Column(name = "ShoppingCart_totalprice")
    private int cart_price;

    //ok
    public int getCartID(){
        return cart_id;
    }
    public void setCartID(int id) {
        this.cart_id = id;
    }

    public int getMemberID(){
        return member_id;
    }
    public void setMemberID(int id) {
        this.member_id = id;
    }

    public int getPrice(){
        return cart_price;
    }
    public void setPrice(int price) {
        this.cart_price = price;
    }
    
}
