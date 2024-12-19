package com.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository
public interface MealTypeRepository extends JpaRepository<MealType, MealTypeId> {

    @Query("SELECT mt FROM MealType mt WHERE mt.type = :type")
    List<MealType> getMealTypesByType(@Param("type") String type);

}
