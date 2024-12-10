package com.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository

public interface CustomizaitonOpRepository extends JpaRepository<CustomizationOp, Integer>{

    
}
