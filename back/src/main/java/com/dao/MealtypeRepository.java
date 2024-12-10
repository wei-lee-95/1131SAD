package com.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository

public interface MealtypeRepository extends JpaRepository<Mealtype, Integer>{

    
}
