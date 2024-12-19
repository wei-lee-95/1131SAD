package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.dao.MealType;
import com.dao.CustomizationOption;
import com.dao.CustomizationOptionRepository;
import com.dao.MealRepository;
import com.dao.MealTypeRepository;

@Service
public class CustomizationOptionService {

    @Autowired
    private CustomizationOptionRepository customizationOptionRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private MealTypeRepository mealTypeRepository;

    public CustomizationOptionService(CustomizationOptionRepository CustomizationOptionRepository) {
        this.customizationOptionRepository = CustomizationOptionRepository;
    }
    
    //目的：show 該餐點可調的客製化選項
    //用"meal" table 裡找到的 meal的type 去對 "mealtype_customization" 的表找對應到的所有customization_id
    //去對 "customizationoption" 表用customization_id找對應到的customization_name 和 adjusted_price並return 出來

    public List<CustomizationOption> getOption(int meal_id){

        String type = mealRepository.findById(meal_id).map(meal -> meal.getType()).orElse(null);
        //List<Integer> CustomizationIDs = mealTypeRepository.findByType(type).stream().map(MealType::getCustom_ID).collect(Collectors.toList());
        
        // 2. 透過 type 從 MealType 表取得對應的所有 customization_id
        List<MealType> mealTypes = mealTypeRepository.getMealTypesByType(type);
        List<Integer> customizationIDs = mealTypes.stream()
                                                  .map(MealType::getCustomization_id)
                                                  .collect(Collectors.toList());


        // 3. 透過 customization_id 從 CustomizationOption 表取得對應的 customization_name 和 adjusted_price
        return customizationOptionRepository.findBycustomizationIDIn(customizationIDs);
    }

    public int getCustomizationPrice(int meal_id, List<Integer> customization_ids){
        int mealPrice = mealRepository.findById(meal_id).map(meal -> meal.getPrice()).orElse(null);
        // 遍歷每個自訂選項，將其調整的價格加到餐點價格上
        for (int customization_id : customization_ids) {
            int adjustedPrice = customizationOptionRepository.findById(customization_id)
                    .map(CustomizationOption -> CustomizationOption.getAdjustedPrice())
                    .orElse(0); // 若找不到自訂選項，則預設加價為 0
            mealPrice += adjustedPrice; // 累加每個自訂選項的價格
        }
        return mealPrice;
    }
}
