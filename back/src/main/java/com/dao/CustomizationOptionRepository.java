
package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository

public interface CustomizationOptionRepository extends JpaRepository<CustomizationOption, Integer>{

    List<CustomizationOption> findBycustomizationIDIn(List<Integer> ids);

}
