<template>
  <div class="OrderCompleted">
    <header>
      <h1>訂單完成</h1>
    </header>

    <p>感謝您的訂購！</p>
    <p>我們正在準備您的餐點。</p>
    <div class="button-container">
      <router-link to="/" class="next-button">返回菜單</router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: 'OrderCompleted'
}
</script>

<style>
.button-container {
  margin-top: 40px;
  display: flex;
  justify-content: center;
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
  margin-top: 40px;
  font-family: 'Noto Sans TC', sans-serif;
}
.next-button:hover {
  background-color: #D2D2D2;
  color: black;
}
</style>
