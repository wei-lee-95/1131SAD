import axios from "axios";

const BASE_URL = "http://localhost:8080/api"

export function fetchMealsByMemberID(memberID) {
  return axios.get(`${BASE_URL}/member/${memberID}`);
}

// 獲取餐點詳細資料和自訂選項
export function fetchMealDetailsWithCustomization(memberID, mealID) {
  return axios.get(`${BASE_URL}/member/${memberID}/meal/${mealID}`);
}

export function addToCart(memberID, mealID, customizationIDs) {
  return axios.post(`${BASE_URL}/cart/addMeal`, {
    memberID,
    mealID,
    customizationIDs,
  });
}
