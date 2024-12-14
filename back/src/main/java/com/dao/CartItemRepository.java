package com.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository

public interface CartItemRepository extends JpaRepository<CartItem, Integer>{

    @Modifying
    @Query(value = "DELETE FROM CartItem c WHERE c.meal_id = :mealID AND c.customization_ids = :customizationIDs")
    void deleteByMealIDAndCustomizationIDs(@Param("mealID") Integer mealID, @Param("customizationIDs") String customizationIDs);

    @Query("SELECT SUM(c.subprice) FROM CartItem c WHERE c.member_id = :memberId")
    Integer calculateTotalSubpriceByMemberId(@Param("memberId") Integer memberId);

    @Query("SELECT c FROM CartItem c WHERE c.member_id = :memberId")
    List<CartItem> findByMemberID(@Param("memberId") int memberId);

    @Modifying
    @Query("DELETE FROM CartItem c WHERE c.member_id = :memberId")
    void deleteByMemberID(@Param("memberId") int memberId);

    @Query("SELECT c FROM CartItem c WHERE c.member_id = :memberId AND c.meal_id = :mealID AND c.customization_ids = :customizationIDs")
    CartItem findByMemberIdAndMealIDAndCustomizationIDs(
    @Param("memberId") Integer memberId,
    @Param("mealID") Integer mealID,
    @Param("customizationIDs") String customizationIDs);

    

}