<template>
  <div class="Checkout">
    <header>
      <h1>確認訂單</h1>
    </header>

    <div class="order-summary">
      <h2>訂單確認</h2>
      <div v-for="(item, index) in cartItems" :key="index" class="order-item">
        <h3>{{ item.name }}</h3>
        <p>數量：{{ item.quantity }}</p>
        <p>小計：NT$ {{ item.price * item.quantity }}</p>
      </div>
      <p>總計：NT$ {{ totalAmount }}</p>
      <textarea
        v-model="comment"
        placeholder="備註事項 (可留空)"
      ></textarea>
      <button v-if="cartItems.length > 0" @click="submitOrder">送出訂單</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'CheckoutPage',
  data () {
    return {
      comment: this.$route.query.comment || '',
      name: '',
      phone: '',
      address: ''
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
    submitOrder () {
      const order = {
        comment: this.comment,
        name: this.name,
        phone: this.phone,
        address: this.address,
        totalPrice: this.totalPrice
      }
      console.log('訂單已成功送出！:', order)
      this.$store.commit('CLEAR_CART') // 清空購物車
      this.$router.push('/order-completed')
    }
  }
}
</script>
