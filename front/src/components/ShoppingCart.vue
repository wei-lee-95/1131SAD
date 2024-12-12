<template>
  <div class="ShoppingCart">
    <header>
      <h1>購物車</h1>
    </header>

    <div v-for="(item, index) in cartItems" :key="index" class="cart-item">
      <img :src="item.image" alt="餐點圖片" />
      <div class="item-info">
        <h2>{{ item.name }}</h2>
        <p>{{ item.customizations }}</p>
        <p>單價：NT$ {{ item.price }}</p>
        <div class="item-actions">
          <button @click="decrementQuantity(item)">-</button>
          <span>{{ item.quantity }}</span>
          <button @click="incrementQuantity(item)">+</button>
          <button @click="removeItem(item)">移除</button>
        </div>
      </div>
    </div>

    <div class="summary">
      <p v-if="cartItems.length === 0">購物車是空的</p>
      <h3>總計 ({{ totalItems }} 件)</h3>
      <p>NT$ {{ totalAmount }}</p>
      <div class="actions">
        <button @click="continueShopping">繼續選購</button>
        <button v-if="cartItems.length > 0" @click="goToCheckout">前往結算</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ShoppingCart',
  props: {
    cart: {
      type: Array,
      required: true
    }
  },
  computed: {
    cartItems () {
      return this.$store.state.cart
    },
    totalAmount () {
      return this.cartItems.reduce((total, item) => total + item.price * item.quantity, 0)
    }
  },
  methods: {
    incrementQuantity (item) {
      this.$store.commit('UPDATE_QUANTITY', { productName: item.name, quantity: item.quantity + 1, customizations: item.customizations })
    },
    decrementQuantity (item) {
      if (item.quantity > 1) {
        this.$store.commit('UPDATE_QUANTITY', { productName: item.name, quantity: item.quantity - 1, customizations: item.customizations })
      }
    },
    removeItem (item) {
      this.$store.commit('REMOVE_FROM_CART', item)
    },
    continueShopping () {
      this.$router.push('/')
    },
    goToCheckout () {
      this.$router.push('/checkout')
    }
  }
}
</script>

<style>
/* 可自訂購物車樣式 */
</style>
