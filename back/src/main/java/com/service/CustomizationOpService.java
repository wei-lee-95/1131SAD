package com.service;

import org.springframework.stereotype.Service;

import com.dao.CustomizationOp;
import com.dao.CustomizationOpRepository;

@Service
public class CustomizationOpService {
    private final CustomizationOpRepository CustomizationOpRepository;

    public CustomizationOpService(CustomizationOpRepository CustomizationOptionRepository) {
        this.CustomizationOpRepository = CustomizationOptionRepository;
    }

    public CustomizationOp showOptionDetailByID(int CustomizationOptionID){//點擊品項後跳出一個框框顯示詳細資料（有什麼客製化可調整）
        return CustomizationOpRepository.findById(CustomizationOptionID).orElse(null);
    }
    
}
