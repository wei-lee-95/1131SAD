package com.dao;

import java.io.Serializable;
import java.util.Objects;

public class MealTypeId implements Serializable {

    private String type; // 必須與 MealType 中的 @Id 屬性匹配
    private int customization_id; // 必須與 MealType 中的 @Id 屬性匹配

    // 無參構造函數
    public MealTypeId() {}

    public MealTypeId(String type, int customization_id) {
        this.type = type;
        this.customization_id = customization_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealTypeId that = (MealTypeId) o;
        return customization_id == that.customization_id && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, customization_id);
    }
}
