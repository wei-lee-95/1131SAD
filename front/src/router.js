import { createRouter, createWebHistory } from 'vue-router'
import BreakfastMenu from '@/components/BreakfastMenu.vue'
import ShoppingCart from '@/views/ShoppingCart.vue'
import Checkout from '@/views/Checkout.vue'
import OrderCompleted from '@/views/OrderCompleted.vue'

const routes = [
  {
    path: '/',
    name: 'Menu',
    component: BreakfastMenu
  },
  {
    path: '/cart',
    name: 'ShoppingCart',
    component: ShoppingCart
  },
  {
    path: '/checkout',
    name: 'Checkout',
    component: Checkout
  },
  {
    path: '/order-completed',
    name: 'OrderCompleted',
    component: OrderCompleted
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
