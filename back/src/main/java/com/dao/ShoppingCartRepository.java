package com.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer>{
    
    //ShoppingCart findBymember_id(int memberID);
    
}