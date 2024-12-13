import axios from 'axios';

const apiClient = axios.create({
    baseURL: 'http://localhost:8080/api', // 後端 API 的基本 URL
    headers: {
        'Content-Type': 'application/json',
    },
    withCredentials: true, // 如果需要傳遞 Cookie
});

export default apiClient;
