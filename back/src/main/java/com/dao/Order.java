
package com.dao;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "orderlist")

public class Order {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "Order_id")
    private int order_id;

    @Column(name = "member_id")
    private int member_id;

    @Column(name = "Order_time")
    private LocalDateTime order_time;

    // @Column(name = "Order_pickuptime")
    // private String pickuptime;

    @Column(name = "Order_status")
    private String status;

    @Column(name = "Order_total_price")
    private int toatl_price;

    @Column(name = "comment")
    private String comment;
//ok
    public int getOrderID(){
        return order_id;
    }
    public void setOrderID(int id) {
        this.order_id = id;
    }

    public int getMemberID(){
        return member_id;
    }
    public void setMemberID(int id) {
        this.member_id = id;
    }

    public LocalDateTime getOrderTime(){
        return order_time;
    }
    public void setOrderTime(LocalDateTime order_time) {
        this.order_time = order_time;
    }

    // public String getPickupTime(){
    //     return pickuptime;
    // }
    // public void setPickupTime(String time) {
    //     this.pickuptime = time;
    // }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrderPrice(){
        return toatl_price;
    }
    public void setOrderPrice(int price) {
        this.toatl_price = price;
    }

    public String getComment(){
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}
