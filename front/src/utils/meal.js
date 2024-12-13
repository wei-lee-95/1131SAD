import axios from "axios";


export function fetchMealsByMemberID(memberID) {
  return axios.get(`http://localhost:8080/api/member/${memberID}`);
}

// 獲取餐點詳細資料和自訂選項
export function fetchMealDetailsWithCustomization(memberID, mealID) {
  return axios.get(`http://localhost:8080/api/member/${memberID}/meal/${mealID}`);
}

