<template>
  <div id="login">
    <div class="login-container">
      <div class="login-icon">
        <img :src="require('@/assets/user-icon.jpg')" alt="User Icon">
      </div>
      <h2>登入</h2>
      <form @submit.prevent="login">
        <div class="input-group">
          <label for="email">電子郵件</label>
          <input type="email" id="email" v-model="email" required>
        </div>
        <div class="input-group">
          <label for="password">密碼</label>
          <input type="password" id="password" v-model="password" required>
        </div>
        <div class="links">
          <a href="#">忘記密碼</a>
          <a href="#">註冊會員</a>
        </div>
        <button type="submit">登入</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      email: '',
      password: ''
    };
  },
  methods: { 
    async login() { 
      try {
        const response = await fetch('http://localhost:8080/api/auth/login', { 
          method: 'POST', 
          headers: { 
            'Content-Type': 'application/json'
          }, 
          body: JSON.stringify({ email: this.email, password: this.password }) 
        }); 
        if (response.ok) { 
          const data = await response.text(); 
          console.log('Login successful:', data); 
        } else { 
          const error = await response.text(); 
          console.error('Login failed:', error); 
        } 
      } catch (err) { 
        console.error('Request error:', err); 
      } 
    }
  }
};
</script>

<style>
#login{
  display: flex; 
  justify-content: center; 
  align-items: center; 
  height: 100vh; 
  margin: 0; 
  padding: 0;
  transform: translateY(-25px);
}
.login-container {
  max-width: 400px;
  padding: 20px;
  border-radius: 10px;
  text-align: center;
}
.login-icon img {
  width: 150px;
  height: 150px;
}
.login-icon { 
  margin-bottom: 10px; 
}
h2 { 
  margin-top: 0;
}
.input-group {
  display: flex; 
  align-items: center;
  flex-direction: row;
  margin-bottom: 15px;
  justify-content: flex-end;
}
.input-group label {
  margin-bottom: 5px;
  margin-right: 10px;
  white-space: nowrap;
  text-align: right;
}
.input-group input {
  width: 200px;
  padding: 7px;
  box-sizing: border-box;
  border-radius: 25px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);
}
.links {
  display: flex;
  justify-content: space-between;
  margin-bottom: 15px;
}
button {
  padding: 10px 20px;
  background-color: white;
  color: black;
  border: 2px solid black;
  border-radius: 5px;
  cursor: pointer;
}
button:hover {
  background-color: black;
  color: white; 
  border: 2px solid black;
}
</style>
