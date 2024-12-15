# 訂餐系統 - 安裝與執行說明書
這是一個基於 **Vue.js** 和 **Spring Boot** 開發的訂餐系統。

### 系統要求:

## 一、資料庫初始化
### 1.下載github中的SQL文件

### 2.將SQL文件導入資料庫管理工具（例如 MySQL Workbench）
#### &nbsp;2-1.點擊MYSQL Connections旁的+號
#### &nbsp;2-2.Connection Name：請輸入 saddb。
#### &nbsp;Connection Method：選擇 Standard (TCP/IP)。
#### &nbsp;Hostname：輸入 localhost（本地連接）。
#### &nbsp;Port：預設為 3306，如果是自定義端口則輸入相應端口。
#### &nbsp;Username：輸入您的 MySQL 用戶名（默認為 root）。
#### &nbsp;Password：點擊 Store in Vault...，然後輸入您的 MySQL 密碼。
#### &nbsp;點擊 Test Connection 以確保可以連接到 MySQL 資料庫。如果成功，點擊 OK 來保存並建立連接。
#### &nbsp;2-3進入此資料庫後，點擊頂部的 File 選單，選擇 Open SQL Script，選擇並打開先前在github中下載的SQL檔案。
#### &nbsp;點擊 Execute 按鈕來執行 SQL 腳本。這會將 SQL 中的所有表結構和數據創建到資料庫中。
