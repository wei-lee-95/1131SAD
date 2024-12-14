<template>
  <div class="product-card">
    <img :src="product.photo" alt="Product Image" class="product-image"/>
    <div class="product-info">
      <h3 class="product-name">{{ product.name }}</h3>
      <p class="product-price">{{ product.price }}元</p>
      <button class="select-meal-button" @click="showCustomization">選擇餐點</button>
    </div>
    <div v-if="isCustomizationVisible" class="customization-modal"> 
      <div class="customization-content"> 
        <h3>{{ product.name}}</h3> 
        <form @submit.prevent="addToCart"> 
          <div class="customization-buttons"> 
            <button 
              type="button" 
              v-for="option in options" 
              :key="option"
              :class="{'selected': customization.options.includes(option.id)}" 
              @click="toggleOption(option.id)"> 
              {{ option.name }}
              <span v-if="option.adjustedPrice > 0"> {{ option.adjustedPrice }}元</span>
            </button> 
          </div>
          <div class="quantity-selector"> 
            <span class="quantity-label">餐點數量：</span>
            <button type="button" class="quantity-button" @click="decreaseQuantity">-</button> 
            <div class="quantity-display">{{ quantity }}</div>
            <button type="button" class="quantity-button" @click="increaseQuantity">+</button> 
          </div>
          <div class="customization-actions">
            <button type="submit" class="add-to-cart-button">加入購物車</button> 
            <button type="button" class="cancel-meal-button" @click="closeCustomization">取消</button> 
          </div>
        </form> 
      </div>
    </div> 
  </div>
</template>

<script>
import { fetchMealDetailsWithCustomization } from "@/utils/meal";
export default {
  name: 'ProductCard',
  props: {
    product: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      isCustomizationVisible: false,
      customization: {
        options:[],
      },
      options: [],
      quantity: 1,
    };
  },
  methods: {
    async getCustomizationOption(mealID) {
      console.log("開始請求客製化選項...");
      const memberID = 1
      try {
        const response = await fetchMealDetailsWithCustomization(memberID, mealID);
        this.options = response.data.customizationOptions.map(option => ({
          id: option.id, 
          name: option.name,
          adjustedPrice: option.adjustedPrice,
        }));      
      } catch (error) {
      console.error("無法取得資料：", error);
      }
    },
    showCustomization() {
      this.isCustomizationVisible = true;
    },
    closeCustomization() {
      this.isCustomizationVisible = false;
    },
    toggleOption(optionID) { 
      const index = this.customization.options.indexOf(optionID); 
      if (index > -1) { 
        this.customization.options.splice(index, 1); 
      } 
      else { 
        this.customization.options.push(optionID); 
      } 
    },
    increaseQuantity(){ 
      this.quantity++; 
    }, 
    decreaseQuantity(){ 
      if(this.quantity > 1){ 
        this.quantity--; 
      } 
    },
    addToCart() {
      const customizedProduct = {
        ...this.product,
        customization: {
          options: this.customization.options,
        },
        quantity: this.quantity,
      };
      this.$emit('add-to-cart', customizedProduct);
      this.closeCustomization();
    },
  },
  mounted() {
    this.getCustomizationOption(this.product.id)
  },
};
</script>

<style>
.product-card {
  flex-grow: 0;
  width: 225px; 
  height: 300px; 
  border: 1px solid #ddd;
  border-radius: 5px;
  padding: 15px;
  margin: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  display: flex;
  flex-direction: column; 
  align-items: center;
  justify-content: space-between; 
}
.product-image {
  width: 80px;
  height: 80px;
  border-radius: 10px;
  margin-bottom: 15px;
}
.product-info {
  text-align: center;
}
.product-name {
  font-size: 1em;
  margin: 0;
  font-family: 'Noto Sans TC', sans-serif;
}
.product-price {
  font-size: 1.2em;
  color: #333;
}
.select-meal-button { 
  padding: 10px 20px; 
  background-color: black; 
  color: white; 
  border: none; 
  border-radius: 5px; 
  cursor: pointer; 
  font-size: 1em; 
  margin-top: 10px; 
  font-family: 'Noto Sans TC', sans-serif;
} 
.select-meal-button:hover { 
  background-color: #D2D2D2; 
  color:black;
}
.customization-modal { 
  position: fixed; 
  top: 0; 
  left: 0; 
  width: 100%; 
  height: 100%; 
  background-color: rgba(0, 0, 0, 0.5); 
  display: flex; 
  justify-content: center; 
  align-items: center; 
} 
.customization-content { 
  background-color: white; 
  padding: 20px; 
  border-radius: 10px; 
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); 
  max-width: 400px; 
  width: 100%; 
  justify-content: center;
  align-items: center;
} 
.customization-buttons button { 
  margin: 5px; 
  padding: 10px;
  font-size: 0.9em; 
  border: 1px solid #ccc; 
  background-color: #fff; 
  cursor: pointer; 
  border-radius: 5px; 
  font-family: 'Noto Sans TC', sans-serif;
} 
.customization-buttons button.selected { 
  background-color: black; 
  color: white; 
  font-weight: bold;
} 
.customization-actions { 
  display: flex; 
  justify-content: space-between; 
  gap: 20px; 
}
.quantity-selector { 
  margin:10px;
  display: flex; 
  align-items: center; 
  justify-content: center; 
  gap: 10px; 
}
.quantity-button{
  width: 40px;
  height: 40px;
  font-size: 1em;
  background-color: #D2D2D2;
  color: black;
  border: none;
  border-radius:50%;
  display:flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
}
.quantity-button:hover{
  background-color: #B9B6B6; 
  color: black; 
}
.quantity-display { 
  width: 50px; 
  text-align: center; 
  font-size: 1.2em; 
  border: 1px solid #ddd; 
  border-radius: 5px; 
  padding: 5px; 
  background-color: #fff; 
} 
.add-to-cart-button { 
  padding: 10px 20px; 
  background-color: black; 
  color: white; 
  border: none; 
  border-radius: 5px; 
  cursor: pointer; 
  font-size: 1em; 
  margin-top: 10px; 
  font-family: 'Noto Sans TC', sans-serif; 
} 
.add-to-cart-button:hover { 
  background-color: #D2D2D2; 
  color: black; 
} 
.cancel-meal-button { 
  padding: 10px 20px; 
  background-color: #fc6b6b;  
  color: white; 
  border: none; 
  border-radius: 5px; 
  cursor: pointer; 
  font-size: 1em; 
  margin-top: 10px; 
  font-family: 'Noto Sans TC', sans-serif; 
}
.cancel-meal-button:hover { 
  background-color: #ff3737;
  color: white; 
} 
</style>
