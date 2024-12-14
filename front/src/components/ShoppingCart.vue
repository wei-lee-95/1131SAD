<template>
  <div id="ShoppingCart">
    <header class = "ShoppingCart-header">
      <h1 class="title">購物車</h1>
    </header>
    <main class="cart">
      <div v-for="(item, index) in cartItems" :key="index" class="cart-item">
        <div class="item-card">
          <img :src="item.meal.photo" alt="餐點圖片" class="item-image"/>
          <div class="item-info-container">
            <div class="item-info">
              <h2 class="item-name">{{ item.meal.name }}</h2>
                <p v-for="(customization, index) in item.customizations" :key="index">
                {{ customization.name }}
                </p>
              <p class="item-price">單價：NT$ {{ item.itemSubprice }}</p>
              <div class="quantity-selector">
                <button class="quantity-button" @click="decrementQuantity(item)">-</button>
                <div class="quantity-display">{{ item.itemQuantity }}</div>
                <button class="quantity-button" @click="incrementQuantity(item)">+</button>
                <button class="remove-meal-button" @click="removeItem(item)">移除</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
    <div class="summary">
      <p v-if="cartItems.length === 0">購物車是空的</p>
      <h3 class="item-total">總計 {{ totalItems }} </h3>
      <p class="item-total">NT$ {{ totalAmount }}</p>
      <div class="actions">
        <button class="next-button" @click="continueShopping">繼續選購</button>
        <button v-if="cartItems.length > 0" class="next-button" @click="goToCheckout">前往結算</button>
      </div>
    </div>
  </div>
</template>

<script>
import { fetchCartByMemberID } from "@/utils/meal"
import { deleteToCart } from "@/utils/meal"; 

export default {
  name: 'ShoppingCart',
  props: {
    cart: {
      type: Array,
      required: true
    }
  },
  data() {
    return {
      cartItems:[],
    };
  },
  computed: {
    /*cartItems () {
      return this.$store.state.cart
    },*/
    totalAmount () {
      return this.cartItems.reduce((total, item) => total + item.itemSubprice * item.itemQuantity, 0)
    }
  }, 
  mounted() {
      this.fetchCart();
  },
  methods: {
    async fetchCart() {
      console.log("開始請求購物車資料...");
      const memberID = 1
      try {
        const response = await fetchCartByMemberID(memberID);
        console.log(response)
        this.cartItems = response.data;       
      } catch (error) {
      console.error("無法取得餐點資料：", error);
      }
    },
    incrementQuantity (item) {
      this.$store.commit('UPDATE_QUANTITY', { productName: item.name, quantity: item.quantity + 1, customizations: item.customizations })
    },
    decrementQuantity (item) {
      if (item.quantity > 1) {
        this.$store.commit('UPDATE_QUANTITY', { productName: item.name, quantity: item.quantity - 1, customizations: item.customizations })
      }
    },
    async removeItem(item) {
      try {
        // 呼叫後端 API 刪除餐點
        console.log()
        const memberID = 1
        const mealID = item.meal.id;
        const customizationIDs = item.customizations.map(c => c.id);
        const response = await deleteToCart(memberID, mealID, customizationIDs);

        if (response.data == "success") {
          this.fetchCart();
        } else {
          // 處理錯誤（如果後端返回錯誤訊息）
          console.error('無法刪除餐點');
        }
      } catch (error) {
        console.error('無法連接後端刪除餐點:', error);
      }
    },
    /* removeItem (item) {
      this.$store.commit('REMOVE_FROM_CART', item)
    }, */
    continueShopping () {
      this.$router.push('/')
    },
    goToCheckout () {
      this.$router.push({
        path: '/checkout',
        query: {
         cartItems: JSON.stringify(this.cartItems) // 傳遞資料
        }
      });
    }
  }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@400;700&display=swap');
body {
  background-color: #F3F3F3;
  font-family: 'Noto Sans TC', sans-serif;
}
.ShoppingCart-header {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 80px;
  margin-bottom: 80px;
  background-color: black;
}
.title {
  margin: 0;
  font-size: 3em;
  font-family: 'Noto Sans TC',san serif;
  color: black;
  margin-right: 600px;
  text-shadow:
    -1px -1px 0 white,
    1px -1px 0 white,
    -1px 1px 0 white,
    1px 1px 0 white;
}
.cart {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.item-info-container {
  display: flex;
  justify-content: center;
  width: 100%;
}
.item-info {
  display: flex;
  justify-content: flex-start;
  align-items: flex-start;
  width: 1800px;
}
.item-card {
  flex-grow: 0;
  width: 900px;
  height: 120px;
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
.item-image {
  justify-content: flex-start;
  width: 80px;
  height: 80px;
  border-radius: 10px;
  margin-bottom: 15px;
}
.item-info {
  text-align: center;
}
.item-name {
  font-size: 1.5em;
  margin: 0;
  font-family: 'Noto Sans TC', sans-serif;
}
.item-price {
  font-size: 1.2em;
  color: #333;
}
.quantity-selector {
  margin:10px;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 10px;
}
.quantuty-button {
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
.remove-meal-button {
  padding: 4px 7px;
  background-color: #fc6b6b;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 0.7em;
  margin-top: 5px;
  justify-items: center;
  font-family: 'Noto Sans TC', sans-serif;
}
.remove-meal-button:hover {
  background-color: #ff3737;
  color: white;
}
.item-total {
  font-size: 1.5em;
  margin: 5;
  font-family: 'Noto Sans TC', sans-serif;
}
.next-button {
  margin: 20px;
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
.next-button:hover {
  background-color: #D2D2D2;
  color: black;
}
</style>
