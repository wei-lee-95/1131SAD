import axios from "axios";

const BASE_URL = "http://localhost:8080/api"

export function fetchMealsByMemberID(memberID) {
  return axios.get(`${BASE_URL}/member/${memberID}`);
}

// 獲取餐點詳細資料和自訂選項
export function fetchMealDetailsWithCustomization(memberID, mealID) {
  return axios.get(`${BASE_URL}/member/${memberID}/meal/${mealID}`);
}

export function addMealToCart(memberID, mealID, quantity, customizationIDs) {
  return axios.post(`${BASE_URL}/cart/addMeal`, {
    memberID,
    mealID,
    quantity,
    customizationIDs,
  });
}

export function fetchCartByMemberID(memberID) {
  return axios.get(`${BASE_URL}/cart/${memberID}`);
}

export function deleteToCart(memberID, mealID, customizationIDs) {
  return axios.post(`${BASE_URL}/cart/deleteMeal`, {
    memberID,
    mealID,
    customizationIDs,
  },
  {
    headers: {
      'Content-Type': 'application/json', // 明確指定 JSON 格式
    },
  });
}

export function addOrder(memberID, comment) {
  return axios.post(`${BASE_URL}/cart/addOrder`, {
    memberID, comment
  },
  {
    headers: {
      "Content-Type": "application/json",  // 確保請求頭部正確
    },
  });
}


export function updateCart(memberID, mealID, newQuantity, customizationIDs) {
  return axios.post(`${BASE_URL}/cart/updateMealQuantity`, {
    memberID, 
    mealID, 
    newQuantity, 
    customizationIDs
  });
}