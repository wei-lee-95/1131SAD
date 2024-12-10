<template>
    <div class="product-card">
      <img :src="product.image" alt="Product Image" class="product-image"/>
      <div class="product-info">
        <h3 class="product-name">{{ product.name }}</h3>
        <p class="product-price">{{ product.price }}元</p>
        <button class="add-to-cart-button" @click="addToCart">加入購物車</button>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'ProductCard',
    props: { 
      product: { 
        type: Object, 
        required: true 
      } 
    }, 
    methods: { 
      addToCart() { 
        this.$emit('add-to-cart', this.product); 
      } 
    }
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
    background-color: rgb(210, 210, 210); 
    color:black;
  }
  </style>
  
