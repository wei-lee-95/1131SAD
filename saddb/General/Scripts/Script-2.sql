-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: saddb
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cartitem`
--
use saddb;
DROP TABLE IF EXISTS `meal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meal` (
  `meal_id` int NOT NULL AUTO_INCREMENT,
  `meal_name` varchar(100) NOT NULL,
  `meal_type` varchar(100) NOT NULL,
  `meal_description` text,
  `meal_price` decimal(10,0) NOT NULL,
  `meal_photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`meal_id`),
  KEY `meal_type` (`meal_type`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meal`
--

LOCK TABLES `meal` WRITE;
/*!40000 ALTER TABLE `meal` DISABLE KEYS */;
INSERT INTO `meal` VALUES (1,'培根吐司','吐司','內容物:吐司、培根(炒洋蔥)、蕃茄醬、黑胡椒、蕃茄片、美生菜',45,'https://cdn-order-v3.nidin.shop/product/images/255/b255_661de27d_ZFOkDpf4.jpg'),(2,'鮪魚沙拉吐司','吐司','內容物:吐司、鮪魚沙拉、番茄片、美生菜',50,'https://cdn-order-v3.nidin.shop/product/images/255/b255_661de293_A1MQ58im.jpg'),(3,'鮮嫩豬柳吐司','吐司','內容物:吐司、蔥爆豬柳、蕃茄醬、黑胡椒、蕃茄片、美生菜 ※ 豬肉原產地:台灣 ※ 來顆蛋，讓你營養滿分',55,'https://cdn-order-v3.nidin.shop/product/images/255/b255_661de2b8_7ABiPG3D.jpg'),(4,'起司辣雞蛋吐司','吐司','內容物:吐司、紐澳良辣雞、起司、散蛋',65,'https://cdn-order-v3.nidin.shop/product/images/255/b255_661de2e3_g8eXZy5G.jpg'),(5,'奶酥吐司','吐司','內容物:吐司、奶酥醬',30,'https://cdn-order-v3.nidin.shop/product/images/255/b255_661de3c9_YaTBsPqQ.jpg'),(6,'早美雞腿排吐司','吐司','原塊去骨雞腿排，裹上酥薄麵衣烘烤鎖住雞肉鮮甜，無法抵擋的誘人滋味! 內容物:雞腿排、洋蔥絲、番茄片、美生菜',75,'https://cdn-order-v3.nidin.shop/product/images/255/b255_661de350_zSqh8cXv.jpg'),(7,'招牌豬肉堡','漢堡','內容物:麵包、漢堡肉、番茄醬、黑胡椒、洋蔥絲、番茄片、美生菜 ※ 加顆蛋，讓美味更加分 ※ 豬肉原產地:台灣',50,'https://cdn-order-v3.nidin.shop/product/images/255/b255_672c580c_aNPU6Ze5.jpg'),(8,'紐奧良辣雞堡','漢堡','內容物:麵包、紐奧良辣雞、番茄醬、黑胡椒、洋蔥絲、番茄片、美生菜 ※ 來顆蛋吧，保證讓你元氣滿滿',60,'https://cdn-order-v3.nidin.shop/product/images/255/b255_661de38c_ApW702mn.jpg'),(9,'里肌豬排堡','漢堡','內容物:麵包、里肌豬排、番茄醬、黑胡椒、洋蔥絲、番茄片、美生菜 ※ 早晨小確幸從多加一顆蛋開始 ※ 豬肉原產地:台灣',65,'https://cdn-order-v3.nidin.shop/product/images/255/b255_672c57d9_WfkAuHxv.jpg'),(10,'阿拉斯加鱈魚堡','漢堡','內容物:麵包、鱈魚排、牛堡醬、黑胡椒、洋蔥絲、番茄片、美生菜',70,'https://cdn-order-v3.nidin.shop/product/images/255/b255_6178c91d_m86cvYQ1.jpg'),(11,'早美雞腿排堡','漢堡','原塊去骨雞腿排，裹上酥薄麵衣烘烤鎖住雞肉鮮甜，無法抵擋的誘人滋味! 內容物:雞腿排、洋蔥絲、番茄片、美生菜',80,'https://cdn-order-v3.nidin.shop/product/images/255/b255_661de375_XSu7L4QA.jpg'),(12,'日式燒肉蛋堡','漢堡','履歷認證的牧場豬五花部位，油脂與瘦肉完美比例，好吃不膩口',70,'https://cdn-order-v3.nidin.shop/product/images/255/b255_6178c66b_e9mzZIgC.jpg'),(13,'墨西哥辣牛肉堡','漢堡','內容物:麵包、牛堡排、起司、牛堡醬、墨西哥辣椒、酸黃瓜、洋蔥絲',70,'https://cdn-order-v3.nidin.shop/product/images/255/b255_6178ce73_3G2XxtEY.jpg'),(14,'薯餅薯餅蛋餅','蛋餅','內容物:薯餅x2、起司、牧場洗選蛋 外酥內軟的雙層金黃薯餅，搭配奶香濃郁起司，紮實餡料的完美爆發。',80,'https://cdn-order-v3.nidin.shop/product/images/255/b255_6730774d_lPsvLNS8.jpg'),(15,'火腿蛋餅','蛋餅','內容物:蛋餅皮、火腿、黑胡椒、牧場洗選蛋',45,'https://cdn-order-v3.nidin.shop/product/images/255/b255_661de542_ixKYep7h.png'),(16,'鮪魚沙拉蛋餅','蛋餅','內容物:蛋餅皮、鮪魚沙拉、牧場洗選蛋',50,'https://cdn-order-v3.nidin.shop/product/images/255/b255_661de56c_qhCGkv0R.png'),(17,'雙重起司蛋餅','蛋餅','內容物:蛋餅皮、蛋、起司、乳酪絲',60,'https://cdn-order-v3.nidin.shop/product/images/255/b255_650d5803_rUcNSIyi.jpg'),(18,'台式瑪格麗特蛋餅','蛋餅','內容物:蛋餅皮、蛋、乳酪絲、蕃茄片、九層塔、蕃茄醬',65,'https://cdn-order-v3.nidin.shop/product/images/255/b255_650d581b_692knYMD.jpg'),(19,'高讚塔豬柳蛋餅','蛋餅','內容物:蛋餅皮、里肌豬排、九層塔、洋蔥絲、黑胡椒、牧場洗選蛋',60,'https://cdn-order-v3.nidin.shop/product/images/255/b255_661de5a3_EjFBxMIu.png'),(20,'薯餅','點心','扎實的馬鈴薯口感 外脆內鬆軟',30,'https://cdn-order-v3.nidin.shop/product/images/255/b255_650d58cc_zNI9F37h.jpg'),(21,'起司條(2條)','點心','香Q軟嫩絲絲入口，香酥的外皮，包裹著濃郁起司 外酥內嫩的口感，絕對是您點心首選！ 搭配「早美特製番茄醬」 沾醬更是銷魂注意:小心燙口',35,'https://cdn-order-v3.nidin.shop/product/images/255/b255_650d58f6_D9BGpPqj.jpg'),(22,'麥克雞塊','點心','一份含有4塊 雞胸肉裹金黃麵衣，嚴選上等雞胸肉新鮮製成，肉質飽滿含肉率80%以上，真材實料肉質細嫩紮實，獨家黃金比例調配，鮮嫩juice外酥內嫩。讓人抵擋不住的金黃美味，好吃的涮口停不下來!',40,'https://cdn-order-v3.nidin.shop/product/images/255/b255_6178d0e7_De7tsqpg.jpg'),(23,'黃金脆薯','點心','扎實的馬鈴薯口感 外脆內鬆軟 淡淡塩味加上酥脆的口感 令人胃口大開 是老饕們心目中的最愛',45,'https://cdn-order-v3.nidin.shop/product/images/255/b255_661de614_uDUt2kaQ.jpg'),(24,'培根玉米濃湯','點心','此商品不需調整比例',45,'https://cdn-order-v3.nidin.shop/product/images/255/b255_66052976_g7jospLV.jpg'),(25,'紅茶','飲料','成分:紅茶、水、糖 ※茶產地: 台灣、印度、斯里蘭卡 甜度固定',20,'https://cdn-order-v3.nidin.shop/product/images/255/b255_661de693_fp689HQn.jpg'),(26,'非基改豆漿','飲料','無添加消泡劑、防腐劑',20,'https://cdn-order-v3.nidin.shop/product/images/255/b255_650d5996_2sr01bf8.jpg'),(27,'牧場鮮奶茶','飲料','採用鮮乳坊單一乳源鮮乳，無成份調整，每一口都喝得放心。 成分:鮮奶、紅茶、糖、水 甜度固定',35,'https://cdn-order-v3.nidin.shop/product/images/255/b255_661de79a_hZSjtT0m.jpg'),(28,'可可拿鐵','飲料','成分:可可粉、咖啡、牛奶 甜度固定',75,'https://cdn-order-v3.nidin.shop/product/images/255/b255_650d5acc_1wjMHfU9.jpg'),(29,'台灣冬片青茶','飲料','品嘗茶湯入口回甘，散發清香而不苦澀 無糖、低咖啡因',25,'https://cdn-order-v3.nidin.shop/product/images/255/b255_650d59b0_MF0RKCnQ.jpg');
/*!40000 ALTER TABLE `meal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

DROP TABLE IF EXISTS `customizationoption`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customizationoption` (
  `customization_id` int NOT NULL AUTO_INCREMENT,
  `customization_name` varchar(100) NOT NULL,
  `customization_adjustedprice` decimal(10,0) NOT NULL,
  PRIMARY KEY (`customization_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customizationoption`
--

LOCK TABLES `customizationoption` WRITE;
/*!40000 ALTER TABLE `customizationoption` DISABLE KEYS */;
INSERT INTO `customizationoption` VALUES (1,'加蛋',10),(2,'加起司',10),(3,'不要番茄',0),(4,'不要美生菜',0),(5,'不要醬',0),(6,'不要洋蔥',0),(7,'不要酸黃瓜',0),(8,'加大',10),(9,'改溫的',0),(10,'去冰',0);
/*!40000 ALTER TABLE `customizationoption` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `shoppingcart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shoppingcart` (
  `ShoppingCart_id` int NOT NULL AUTO_INCREMENT,
  `member_id` int NOT NULL,
  `ShoppingCart_totalprice` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`ShoppingCart_id`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `shoppingcart_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoppingcart`
--

LOCK TABLES `shoppingcart` WRITE;
/*!40000 ALTER TABLE `shoppingcart` DISABLE KEYS */;
/*!40000 ALTER TABLE `shoppingcart` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `cartitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cartitem` (
  `CartItem_id` int NOT NULL AUTO_INCREMENT,
  `ShoppingCart_id` int NOT NULL,
  `meal_id` int NOT NULL,
  `CartItem_quantity` int NOT NULL,
  `CartItem_itemsubprice` decimal(10,2) NOT NULL,
  `customization_id` int DEFAULT NULL,
  PRIMARY KEY (`CartItem_id`),
  KEY `ShoppingCart_id` (`ShoppingCart_id`),
  KEY `meal_id` (`meal_id`),
  KEY `customization_id` (`customization_id`),
  CONSTRAINT `cartitem_ibfk_1` FOREIGN KEY (`ShoppingCart_id`) REFERENCES `shoppingcart` (`ShoppingCart_id`),
  CONSTRAINT `cartitem_ibfk_2` FOREIGN KEY (`meal_id`) REFERENCES `meal` (`meal_id`),
  CONSTRAINT `cartitem_ibfk_3` FOREIGN KEY (`customization_id`) REFERENCES `customizationoption` (`customization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartitem`
--

LOCK TABLES `cartitem` WRITE;
/*!40000 ALTER TABLE `cartitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `cartitem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;



DROP TABLE IF EXISTS `mealtype_customization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mealtype_customization` (
  `meal_type` varchar(50) NOT NULL,
  `customization_id` int NOT NULL,
  PRIMARY KEY (`meal_type`,`customization_id`),
  KEY `customization_id` (`customization_id`),
  CONSTRAINT `mealtype_customization_ibfk_1` FOREIGN KEY (`meal_type`) REFERENCES `meal` (`meal_type`),
  CONSTRAINT `mealtype_customization_ibfk_2` FOREIGN KEY (`customization_id`) REFERENCES `customizationoption` (`customization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mealtype_customization`
--

LOCK TABLES `mealtype_customization` WRITE;
/*!40000 ALTER TABLE `mealtype_customization` DISABLE KEYS */;
INSERT INTO `mealtype_customization` VALUES ('吐司',1),('漢堡',1),('蛋餅',1),('吐司',2),('漢堡',2),('蛋餅',2),('吐司',3),('漢堡',3),('吐司',4),('漢堡',4),('吐司',5),('漢堡',5),('蛋餅',5),('點心',5),('漢堡',6),('漢堡',7),('飲料',8),('飲料',9),('飲料',10);
/*!40000 ALTER TABLE `mealtype_customization` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-09 15:53:19

-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: saddb
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `member_id` int NOT NULL AUTO_INCREMENT,
  `member_name` varchar(100) NOT NULL,
  `member_phonenumber` varchar(15) NOT NULL,
  `member_password` varchar(255) NOT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'tester','0912345678','1234567');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-09 15:53:19

-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: saddb
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `Order_id` int NOT NULL AUTO_INCREMENT,
  `member_id` int NOT NULL,
  `Order_time` datetime NOT NULL,
  `Order_pickuptime` datetime NOT NULL,
  `Order_status` varchar(50) NOT NULL,
  `Order_total_price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`Order_id`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-09 15:53:19

-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: saddb
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `orderitem`
--

DROP TABLE IF EXISTS `orderitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderitem` (
  `OrderItem_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `meal_id` int NOT NULL,
  `OrderItem_quantity` int NOT NULL,
  `OrderItem_itemsubprice` decimal(10,2) NOT NULL,
  `customization_id` int DEFAULT NULL,
  PRIMARY KEY (`OrderItem_id`),
  KEY `order_id` (`order_id`),
  KEY `meal_id` (`meal_id`),
  KEY `customization_id` (`customization_id`),
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`Order_id`),
  CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`meal_id`) REFERENCES `meal` (`meal_id`),
  CONSTRAINT `orderitem_ibfk_3` FOREIGN KEY (`customization_id`) REFERENCES `customizationoption` (`customization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitem`
--

LOCK TABLES `orderitem` WRITE;
/*!40000 ALTER TABLE `orderitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderitem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-09 15:53:19

-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: saddb
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `shoppingcart`
--


/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-09 15:53:19

