import { createStore } from 'vuex'

export default createStore({
  state: {
    cart: [] // 初始購物車為空
  },
  getters: {
    cartItems: state => state.cart,
    totalItems: state => state.cart.reduce((total, item) => total + item.quantity, 0),
    totalPrice: state => state.cart.reduce((total, item) => total + item.price * item.quantity, 0)
  },
  mutations: {
    ADD_TO_CART (state, product) {
      const customizedProduct = {
        ...product,
        customization: product.customization || { options: [] },
        quantity: product.quantity
      }
      const existingItem = state.cart.find(item =>
        item.name === customizedProduct.name &&
        JSON.stringify(item.customization) === JSON.stringify(customizedProduct.customization)
      )
      if (existingItem) {
        existingItem.quantity += product.quantity
      } else {
        state.cart.push(product)
      }
    },
    UPDATE_QUANTITY (state, { productName, quantity, customizations }) {
      const item = state.cart.find(item =>
        item.name === productName &&
        JSON.stringify(item.customizations) === JSON.stringify(customizations)
      )
      if (item) {
        item.quantity = quantity
      }
    },
    REMOVE_FROM_CART (state, product) {
      state.cart.splice(product, 1)
    },
    CLEAR_CART (state) {
      state.cart = []
    }
  },
  actions: {
    // 可新增異步行為
  }
})
