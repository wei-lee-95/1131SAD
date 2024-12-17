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
-- Table structure for table `mealtype_customization`
--

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
