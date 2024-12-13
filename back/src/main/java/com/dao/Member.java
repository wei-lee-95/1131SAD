package com.dao;

//import org.springframework.boot.autoconfigure.domain.EntityScan;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "member_id")  // 映射到資料庫中的 memberID 欄位
    private int memberID;

    @Column(name = "member_name")
    private String name;

    @Column(name = "member_phonenumber")
    private String phoneNumber;

    public int getID(){
        return memberID;
    }

    public void setId(int id) {
        this.memberID = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
}
