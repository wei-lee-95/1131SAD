<template>
  <div id="Checkout">
    <header class="checkout-header">
      <h1 class="checkout-title">訂單確認</h1>
    </header>

    <div class="order-summary">
      <div v-for="(item, index) in cartItems" :key="index" class="order-item">
        <div class="item-card">
          <div class="item-info-container">
            <h3 class="item-name">{{ item.meal.name }}</h3>
            <p class="item-price">數量：{{ item.itemQuantity }}</p>
            <p class="item-price">小計：NT$ {{ item.itemSubprice * item.itemQuantity }}</p>
          </div>
        </div>
      </div>
      <p class="item-total">總計：NT$ {{ totalAmount }}</p>
      <textarea
        v-model="comment"
        placeholder="備註事項 (可留空)"
        class ="textarea"
      ></textarea>
      <button v-if="cartItems.length > 0" class="next-button" @click="submitOrder">送出訂單</button>
    </div>
  </div>
</template>

<script>
import { addOrder } from "@/utils/meal"; 
export default {
  name: 'CheckoutPage',
  data () {
    return {
      cartItems: JSON.parse(this.$route.query.cartItems || '[]'), // 從路由讀取資料
      comment: this.$route.query.comment || '',
      name: '',
      phone: '',
      /* address: '' */
    };
  },
  computed: {
    /* cartItems () {
      return this.$store.state.cart
    }, */
    totalAmount () {
      return this.cartItems.reduce((total, item) => total + item.itemSubprice * item.itemQuantity, 0)
    }
  },
  methods: {
/*     submitOrder () {
      const order = {
        comment: this.comment,
        name: this.name,
        phone: this.phone,
        /* address: this.address, */
 /*        totalPrice: this.totalPrice
      }
      console.log('訂單已成功送出！:', order)
      this.$store.commit('CLEAR_CART') // 清空購物車
      this.$router.push('/order-completed')
    }, */ 
    submitOrder() {  
      const memberID = 1
      const comment = this.comment || '';
      if (isNaN(memberID)) {
        console.error("Invalid memberID");
      }
      console.log(this.comment)
      addOrder(memberID, comment)
        .then(() => {
          alert("訂單已成功送出！");
          this.$router.push('/order-completed')
        })
        .catch((error) => {
          console.error("失敗:", error);
          alert("失敗，請稍後再試！");
        });
    },
  }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@400;700&display=swap');
body {
  background-color: #F3F3F3;
  font-family: 'Noto Sans TC', sans-serif;
}

.checkout-header {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 80px;
  margin-bottom: 80px;
  background-color: black;
}

.checkout-title {
  margin: 0;
  font-size: 3em;
  font-family: 'Noto Sans TC',san serif;
  color: black;
  justify-content: center;
  align-items: center;
  text-shadow:
    -1px -1px 0 white, /* 上左 */
    1px -1px 0 white,  /* 上右 */
    -1px 1px 0 white,  /* 下左 */
    1px 1px 0 white;  /* 下右 */
 }  

.order-summary {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.item-card {
  flex-grow: 0;
  width: 600px;
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
.item-info-container {
  display: flex;
  justify-content: center;
  width: 100%;
}
.item-name {
  font-size: 1.5em;
  margin: 0;
  font-family: 'Noto Sans TC', sans-serif;
  justify-content: center;
  align-items: center;
  padding: 40px;
}
.item-price {
  font-size: 1.2em;
  color: #333;
  padding: 25px;
}
.textarea {
  width: 300px;
  height: 20px;
  text-align: center;
  padding: 10px;
}
.next-button {
  margin: 10px;
  padding: 10px 20px;
  background-color: rgb(255, 255, 255);
  color: rgb(0, 0, 0);
  border: none;
  border-radius: 5px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  cursor: pointer;
  font-size: 1em;
  margin-top: 20px;
  font-family: 'Noto Sans TC', sans-serif;
}
.next-button:hover {
  background-color: #D2D2D2;
  color: black;
}
.item-total {
  font-size: 1.5em;
  margin: 10;
  padding: 15px;
  font-family: 'Noto Sans TC', sans-serif;
}
</style>
