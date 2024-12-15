<template>
  <div id="menu">
    <header class="menu-header">
      <h1 class="menu-title">緊來呷早餐店</h1>
      <div class="header-right">
        <div class="search-container"> 
          <input type="text" placeholder="請輸入搜尋餐點..." v-model="searchQuery" class="search-bar"/> 
          <button @click="searchItems" class="search-button"> 
            <img :src="require('@/assets/search-icon.png')" alt="搜尋圖示" class="search-icon"/> 
          </button>
        </div>
          <router-link to="/cart"> 
          <img :src="require('@/assets/shopping-cart-2.png')" alt="購物車圖標" class="shopping-cart-icon"/>
        </router-link>
      </div>
    </header>
    <nav class="categories">
      <button
        v-for="category in categories" 
        :key="category.name" 
        @click="selectCategory(category.name)" 
        :class="{'active': selectedCategory === category.name, 'category-button': true}"> 
        <img 
          v-if="category.iconActive && category.iconInactive"
          :src="getCategoryIcon(category)" 
          :alt="category.name + ' icon'" 
          class="category-icon" /> 
          {{ category.name }}
      </button>
    </nav>
    <main class="menu">
      <div class="product-grid-container">
        <div class="product-grid">
          <ProductCard 
            v-for="item in filteredItems" 
            :key="item.name" 
            :product="item" 
            @add-to-cart="addToCart"/>
        </div>
      </div>
    </main>
  </div>
</template>

<script>
import ProductCard from './ProductCard.vue';
import { fetchMealsByMemberID } from "@/utils/meal";
import { addToCart } from "@/utils/meal"; 

export default {
  name: 'BreakfastMenu',
  components: {
    ProductCard
  },
  data() {
    return {
      searchQuery: '',
      selectedCategory: '',
      categories: [
      { name: '全部', iconActive: '', iconInactive: '' }, 
      { name: '吐司', iconActive: 'sandwich.png', iconInactive: 'sandwich-un.png' }, 
      { name: '漢堡', iconActive: 'burger.png', iconInactive: 'burger-un.png' }, 
      { name: '蛋餅', iconActive: 'eggroll.png', iconInactive: 'eggroll-un.png' }, 
      { name: '點心', iconActive: 'fries.png', iconInactive: 'fries-un.png' }, 
      { name: '飲料', iconActive: 'drink.png', iconInactive: 'drink-un.png' },
      ],
      items: [],
      cart: []
    };
  },
  computed: {
    filteredItems() {
      return this.items.filter(item => {
        return (this.selectedCategory === '' || this.selectedCategory === '全部' || item.type === this.selectedCategory) &&
             (!this.searchQuery || item.name.includes(this.searchQuery));
      })
    }
  },
  created() {
      // 組件掛載完成後，立即載入餐點資料
      console.log("組件已掛載，開始加載餐點資料...");
      this.fetchMeals();
  },
  methods: {
    async fetchMeals() {
      console.log("開始請求餐點資料...");
      const memberID = 1
      try {
        const response = await fetchMealsByMemberID(memberID);
        this.items = response.data.meals;       
      } catch (error) {
      console.error("無法取得餐點資料：", error);
      }
    },
    selectCategory(category) {
      this.selectedCategory = category;
    },
    getCategoryIcon(category) { 
      if (!category.iconActive || !category.iconInactive) { 
        return null; 
      }
      return this.selectedCategory === category.name ? 
      require(`@/assets/${category.iconActive}`) : 
      require(`@/assets/${category.iconInactive}`); 
    },
    addToCart(product) { 
      //this.cart.push(product); 
      const memberID = 1
      const mealID = product.id;
      const customizationIDs = product.customization.options
      addToCart(memberID, mealID, product.quantity, customizationIDs)
        .then(() => {
          alert(`${product.name} 已加入購物車!`);
        })
        .catch((error) => {
          console.error("加入購物車失敗:", error);
          alert("加入購物車失敗，請稍後再試！");
        });
    },
    searchItems() {
      alert(`搜尋結果：${this.searchQuery}`); 
    },
  }
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@400;700&display=swap');
body {
  background-color: #F3F3F3; 
  font-family: 'Noto Sans TC', sans-serif; 
}

.menu-header {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 20px;
  margin-bottom: 20px;
  background-color: black;
}
.menu-title {
  margin: 0;
  font-size: 3em;
  font-family: 'Noto Sans TC',san serif;
  color: black;
  margin-right: 600px;
  text-shadow: 
    -1px -1px 0 white, /* 上左 */ 
    1px -1px 0 white, /* 上右 */ 
    -1px 1px 0 white, /* 下左 */ 
    1px 1px 0 white; /* 下右 */
}
.header-right {
  display: flex;
  align-items: center;
}
.search-container { 
  position: relative; 
  display: flex; 
  align-items: center; 
}
.search-bar {
  padding: 10px; 
  margin-right: 10px; 
  border-radius: 25px; 
  width: 200px; 
  outline: none; 
  font-size: 16px; 
  background-color: #F3F3F3;
  padding-right: 40px;
  text-indent: 10px;
}
.search-button { 
  position: absolute;
  right: 15px;
  background: none; 
  border: none; 
  cursor: pointer; 
} 
.search-icon { 
  width: 43px; 
  height: 36px; 
}
.shopping-cart-icon { 
  width: 40px; 
  height: 40px; 
  margin-left: 20px;
  filter: invert(1);
}
.categories {
  text-align: center;
  margin-bottom: 20px;
  display: flex;
  flex-wrap: nowrap; 
  justify-content: center; 
}
.category-button {
  padding: 10px 40px;
  background-color: #dfdede;
  color: black;
  border: none;
  border-radius: 30px;
  cursor: pointer;
  margin: 5px 15px ;
  font-size: 1.5em;
  display: flex; 
  align-items: center;
  font-family: 'Noto Sans TC', sans-serif;
}
.category-button:hover { 
    background-color: white; 
    color:black;
  }
.category-button.active {
  background-color:white;
  color:black;
  font-weight: bold;
  border: none; 
}
.menu {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.product-grid-container { 
  display: flex; 
  justify-content: center; 
  width: 100%;
}
.product-grid {
  display: flex;
  flex-wrap: wrap;
  justify-content: flex-start;
  align-items: flex-start;
  width: 1200px;
  gap: 31px;
}
.product-grid .product-card { 
  margin: 10px; 
}
.category-icon { 
  width: 38px; 
  height: 38px; 
  margin-right: 10px; 
}
</style>
