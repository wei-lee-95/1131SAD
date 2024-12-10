import { createRouter, createWebHistory } from 'vue-router';
import BreakfastMenu from './components/BreakfastMenu.vue';
import ShoppingCart from './components/ShoppingCart.vue';

const routes = [
  {
    path: '/',
    name: 'BreakfastMenu',
    component: BreakfastMenu
  },
  {
    path: '/cart',
    name: 'ShoppingCart',
    component: ShoppingCart
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;
