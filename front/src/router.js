import { createRouter, createWebHistory } from 'vue-router'
import BreakfastMenu from '@/components/BreakfastMenu.vue'
import ShoppingCart from '@/components/ShoppingCart.vue'
import Checkout from '@/components/Checkout.vue'
import OrderCompleted from '@/components/OrderCompleted.vue'

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
