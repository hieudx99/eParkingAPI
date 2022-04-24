-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: eparking
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `tbl_bill`
--

DROP TABLE IF EXISTS `tbl_bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_bill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_date` datetime NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `total` double NOT NULL,
  `payment_status` varchar(255) NOT NULL,
  `payment_methodid` int NOT NULL,
  `parking_slotid` int NOT NULL,
  `carid` int NOT NULL,
  `userid` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `payment_methodid` (`payment_methodid`),
  KEY `parking_slotid` (`parking_slotid`),
  KEY `carid` (`carid`),
  KEY `userid` (`userid`),
  CONSTRAINT `tbl_bill_ibfk_1` FOREIGN KEY (`payment_methodid`) REFERENCES `tbl_payment_method` (`id`),
  CONSTRAINT `tbl_bill_ibfk_2` FOREIGN KEY (`parking_slotid`) REFERENCES `tbl_parking_slot` (`id`),
  CONSTRAINT `tbl_bill_ibfk_3` FOREIGN KEY (`carid`) REFERENCES `tbl_car` (`id`),
  CONSTRAINT `tbl_bill_ibfk_4` FOREIGN KEY (`userid`) REFERENCES `tbl_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_bill`
--

LOCK TABLES `tbl_bill` WRITE;
/*!40000 ALTER TABLE `tbl_bill` DISABLE KEYS */;
INSERT INTO `tbl_bill` VALUES (1,'2022-03-27 00:00:00','2022-03-27 00:01:00','2022-03-27 00:02:00',50000,'O',1,1,1,1),(2,'2022-03-28 00:00:00','2022-03-28 00:01:00','2022-03-29 00:02:00',50000,'O',1,1,1,1),(5,'2022-03-28 00:00:00','2022-03-28 00:01:00','2022-03-29 00:02:00',50000,'O',1,1,1,3),(6,'2022-03-28 08:14:47','2022-03-28 00:01:00','2022-03-29 00:02:00',50000,'O',1,1,1,1),(7,'2022-03-28 10:32:20','2022-03-28 00:01:00','2022-03-29 00:02:00',50000,'O',1,2,1,2),(8,'2022-03-28 10:34:44','2022-03-28 00:01:00','2022-03-29 00:02:00',50000,'O',1,2,1,1),(9,'2022-03-28 11:07:54','2022-03-28 00:01:00','2022-03-29 00:02:00',50000,'O',1,2,1,1),(10,'2022-03-28 11:20:57','2022-03-28 00:01:00','2022-03-28 00:01:15',50000,'O',1,2,1,2),(11,'2022-03-28 11:22:10','2022-03-28 00:01:00','2022-03-28 00:01:15',50000,'O',1,2,1,1),(12,'2022-03-28 11:24:15','2022-03-28 00:01:00','2022-03-28 00:01:15',50000,'O',1,2,1,3),(13,'2022-03-28 11:28:46','2022-03-28 00:01:00','2022-03-28 00:01:15',50000,'O',1,2,1,3),(14,'2022-03-28 11:37:09','2022-03-28 00:01:00','2022-03-28 00:01:15',50000,'O',1,2,1,4),(15,'2022-03-28 11:41:00','2022-03-28 00:01:00','2022-03-28 00:01:15',50000,'O',1,2,1,2),(16,'2022-03-28 11:42:36','2022-03-28 00:01:00','2022-03-28 00:01:15',50000,'O',1,2,1,1),(17,'2022-03-28 11:49:37','2022-03-28 00:01:00','2022-03-28 00:01:15',50000,'O',1,2,1,5),(18,'2022-04-01 08:28:11','2022-04-01 20:00:00','2022-04-01 20:29:00',50000,'O',1,1,1,1),(19,'2022-04-01 08:28:47','2022-04-01 08:00:00','2022-04-01 08:29:00',50000,'O',1,1,1,1),(22,'2022-04-03 09:49:36','2022-04-03 09:00:00','2022-04-03 10:00:00',50000,'O',1,1,1,1),(23,'2022-04-03 09:52:04','2022-04-03 09:00:00','2022-04-03 10:00:00',50000,'O',1,2,1,1),(24,'2022-04-03 09:52:10','2022-04-03 09:00:00','2022-04-03 10:00:00',50000,'O',1,3,1,1),(25,'2022-04-03 09:52:19','2022-04-03 09:00:00','2022-04-03 10:00:00',50000,'O',1,4,1,1),(26,'2022-04-03 09:52:23','2022-04-03 09:00:00','2022-04-03 10:00:00',50000,'O',1,5,1,1),(27,'2022-04-03 09:52:32','2022-04-03 09:00:00','2022-04-03 10:00:00',50000,'O',1,5,1,1),(28,'2022-04-03 09:52:51','2022-04-03 09:00:00','2022-04-03 10:00:00',50000,'O',1,6,1,1),(29,'2022-04-03 09:53:48','2022-04-03 09:00:00','2022-04-03 10:00:00',50000,'O',1,10,1,1),(30,'2022-04-09 01:55:00','2022-04-09 09:00:00','2022-04-09 14:00:00',50000,'O',1,10,1,1),(31,'2022-04-11 05:25:32','2022-04-11 17:25:00','2022-04-11 18:35:00',58500,'O',3,1,1,1),(32,'2022-04-11 05:27:35','2022-04-11 17:27:00','2022-04-11 17:47:00',16500,'O',3,2,1,1),(33,'2022-04-11 05:28:14','2022-04-11 17:27:00','2022-04-11 17:47:00',16500,'O',3,2,1,1),(34,'2022-04-11 05:28:36','2022-04-11 17:28:00','2022-04-11 18:38:00',58500,'O',2,3,1,1),(35,'2022-04-11 05:31:55','2022-04-11 17:31:00','2022-04-11 18:42:00',59000,'O',3,4,1,1),(36,'2022-04-11 05:44:45','2022-04-11 17:44:00','2022-04-11 19:07:00',69000,'O',3,5,1,1),(37,'2022-04-11 05:46:20','2022-04-11 17:44:00','2022-04-11 19:07:00',69000,'O',3,5,1,1),(38,'2022-04-11 05:47:26','2022-04-11 17:47:00','2022-04-11 18:48:00',51000,'O',3,6,1,1),(39,'2022-04-11 05:49:04','2022-04-11 17:48:00','2022-04-11 19:53:00',104000,'O',3,7,1,1),(40,'2022-04-11 05:50:28','2022-04-11 17:50:00','2022-04-11 18:53:00',52500,'O',2,8,1,1),(41,'2022-04-11 05:51:14','2022-04-11 17:50:00','2022-04-11 20:50:00',150000,'O',2,9,1,1),(42,'2022-04-11 05:52:06','2022-04-11 17:51:00','2022-04-11 23:51:00',300000,'O',3,11,1,1),(43,'2022-04-11 05:53:49','2022-04-11 17:53:00','2022-04-11 19:53:00',100000,'O',2,12,1,1),(44,'2022-04-11 05:54:01','2022-04-11 17:53:00','2022-04-11 19:53:00',100000,'O',2,12,1,1),(45,'2022-04-11 05:55:25','2022-04-11 17:55:00','2022-04-11 18:55:00',50000,'O',3,13,1,1),(46,'2022-04-11 05:55:42','2022-04-11 17:55:00','2022-04-11 20:55:00',150000,'O',3,14,1,1),(47,'2022-04-11 07:21:53','2022-04-11 19:20:00','2022-04-11 19:25:00',4000,'O',3,1,1,1),(52,'2022-04-12 11:14:09','2022-04-12 11:13:00','2022-04-12 13:19:00',105000,'O',2,2,1,1),(53,'2022-04-12 04:16:14','2022-04-12 16:15:00','2022-04-12 18:15:00',100000,'O',3,1,2,1),(54,'2022-04-12 06:59:01','2022-04-12 18:58:00','2022-04-12 21:12:00',111500,'O',3,3,2,1),(55,'2022-04-13 09:35:53','2022-04-13 09:35:00','2022-04-13 10:35:00',50000,'O',3,4,1,1),(56,'2022-04-13 09:36:22','2022-04-13 09:36:00','2022-04-13 11:36:00',100000,'O',2,5,2,1),(58,'2022-04-14 16:39:08','2022-04-14 16:38:00','2022-04-14 17:38:00',50000,'O',3,6,2,1),(59,'2022-04-14 22:19:33','2022-04-14 22:19:00','2022-04-14 22:21:00',1500,'O',3,6,2,1),(60,'2022-04-17 10:42:35','2022-04-17 10:41:00','2022-04-17 10:43:00',1500,'O',3,1,13,1),(61,'2022-04-17 10:52:46','2022-04-17 10:51:00','2022-04-18 10:51:00',1200000,'O',3,3,1,1),(62,'2022-04-17 10:52:58','2022-04-17 10:51:00','2022-04-18 10:51:00',1200000,'O',3,3,2,1),(63,'2022-04-22 22:51:29','2022-04-22 22:50:00','2022-04-23 20:50:00',1100000,'O',2,1,14,13),(64,'2022-04-23 10:29:08','2022-04-23 10:28:00','2022-04-23 12:28:00',100000,'O',3,2,14,13),(65,'2022-04-23 15:32:37','2022-04-23 15:31:00','2022-04-25 16:33:00',2451500,'O',2,3,14,13),(66,'2022-04-24 17:49:45','2022-04-24 17:49:00','2022-04-25 17:50:00',1201000,'O',3,4,15,13);
/*!40000 ALTER TABLE `tbl_bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_brand`
--

DROP TABLE IF EXISTS `tbl_brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_brand` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_brand`
--

LOCK TABLES `tbl_brand` WRITE;
/*!40000 ALTER TABLE `tbl_brand` DISABLE KEYS */;
INSERT INTO `tbl_brand` VALUES (1,'Vin'),(2,'Honda'),(3,'Mec'),(4,'Audi');
/*!40000 ALTER TABLE `tbl_brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_car`
--

DROP TABLE IF EXISTS `tbl_car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_car` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `color` varchar(255) NOT NULL,
  `license_plate` varchar(255) NOT NULL,
  `seat_number` int NOT NULL,
  `brandid` int NOT NULL,
  `userid` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `license_plate` (`license_plate`),
  KEY `userid` (`userid`),
  KEY `tbl_car_ibfk_2_idx` (`brandid`),
  CONSTRAINT `tbl_car_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `tbl_user` (`id`),
  CONSTRAINT `tbl_car_ibfk_2` FOREIGN KEY (`brandid`) REFERENCES `tbl_brand` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_car`
--

LOCK TABLES `tbl_car` WRITE;
/*!40000 ALTER TABLE `tbl_car` DISABLE KEYS */;
INSERT INTO `tbl_car` VALUES (1,'VINFAST LUX  A2.5','White','30A-111.11',4,1,1),(2,'Honda City','Red','30A-555.55',4,2,1),(3,'VINFAST LUX  A3.0','White','30A-111.22',4,1,1),(4,'VINFAST LUX  A3.5','White','30A-111.33',4,1,2),(5,'VINFAST LUX  A4.0','White','30A-111.44',4,1,2),(7,'VIN FADIL','RED','30A-123.45',5,1,1),(8,'VIN FADIL','WHITE','30A-112.33',5,1,1),(9,'VIN FADIL','RED','30A-667.78',5,1,1),(10,'VIN FADIL','RED','36A-666.66',5,1,1),(11,'VIN FADIL','WHITE','36A-999.99',5,1,1),(12,'VIN FADIL','RED','36A-888.88',5,1,1),(13,'VIN FADIL','RED','36A-111.11',5,1,1),(14,'CarTest1Edited','White','36B7-844.57',4,2,13),(15,'CarTest2Edited','WhiteEdited','36B8-87321',4,2,13),(16,'Car Test 3','Red','36A1-12312',4,4,13),(17,'car test 4','Red','36B1-22772',4,4,13),(18,'Car Test 5','Black','36D7-21344',4,3,13),(19,'Car Tét 6','White','36G7-12331',5,3,13),(20,'Ca Tét 7','BB','36E&-13289',5,1,13),(21,'Ca Tét 8','AA','36T1-88888',5,1,13);
/*!40000 ALTER TABLE `tbl_car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_parking_slot`
--

DROP TABLE IF EXISTS `tbl_parking_slot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_parking_slot` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_parking_slot`
--

LOCK TABLES `tbl_parking_slot` WRITE;
/*!40000 ALTER TABLE `tbl_parking_slot` DISABLE KEYS */;
INSERT INTO `tbl_parking_slot` VALUES (1,'A1','U'),(2,'A2','U'),(3,'A3','U'),(4,'A4','U'),(5,'A5','O'),(6,'B1','O'),(7,'B2','O'),(8,'B3','O'),(9,'B4','O'),(10,'B5','O'),(11,'C1','O'),(12,'C2','O'),(13,'C3','O'),(14,'C4','O'),(15,'C5','O');
/*!40000 ALTER TABLE `tbl_parking_slot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_payment_method`
--

DROP TABLE IF EXISTS `tbl_payment_method`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_payment_method` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_payment_method`
--

LOCK TABLES `tbl_payment_method` WRITE;
/*!40000 ALTER TABLE `tbl_payment_method` DISABLE KEYS */;
INSERT INTO `tbl_payment_method` VALUES (1,'VNPAY'),(2,'MOMO'),(3,'ZALOPAY');
/*!40000 ALTER TABLE `tbl_payment_method` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_role`
--

DROP TABLE IF EXISTS `tbl_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_role`
--

LOCK TABLES `tbl_role` WRITE;
/*!40000 ALTER TABLE `tbl_role` DISABLE KEYS */;
INSERT INTO `tbl_role` VALUES (1,'user'),(2,'admin');
/*!40000 ALTER TABLE `tbl_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `identity_card` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `roleid` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `identity_card` (`identity_card`),
  UNIQUE KEY `telephone` (`telephone`),
  KEY `tbl_user_ibfk_1` (`roleid`),
  CONSTRAINT `tbl_user_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `tbl_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user`
--

LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` VALUES (1,'hieudx1','$2a$10$hj2cMU6DYwSWzasr87Lyh.am2Wg.4E.WRDanUyQQHQuJelQ9X4tjm','hieudx1@gmail.com','Đỗ Xuân Hiếu','038011223344','0976199401','Bắc Từ Liêm',1),(2,'duyvd','$2a$10$JTRsfqgsy9ZrogGG5Yq6LeV36UK9z5ohGyZqiWFVllxgHqKlWfBTK','duyvd@gmail.com','Vũ Đức Duy','038012341234','0912312433','Hoàng Mai',1),(3,'longnb','$2a$10$fTXLGqAe/whQQCnDG9/qa.C6Fsomb7X7Uh8z78oUnbG5aJAMS2/FW','longnb@gmail.com','Nguyễn Bảo Long','038046641564','0976454513','Hoài Đức',1),(4,'lochd','$2a$10$k/zWdjFSMxvh4dM6VqOcWedgapNX4TEFg5R2UqB6h9ycHJcNXI//O','lochd@gmail.com','Hoàng Đình Lộc','038012345698','0954646161','Thanh Xuân',1),(5,'binhnt1','$2a$10$XERLkAkTZPhomMKvrdHKFOeWBXgq8tNV/EPi4GodiskrkTgB3Xgcm','binhnt@gmail.com','Nguyễn Thanh Bình','038018794245','0912313255','Hoàng Mai',1),(7,'admin','$2a$10$HZzNju91MwVrElEMtrVPyeQtMNR39zio3GB6Yex2BA.2ob0VKCZnS','admin@gmail.com','Admin','','','',2),(8,'dathd','$2a$10$BeXYsOCK15CzICVssYFZc.3ibk.ks8/NJV4TC3gN7ET2ANSk2losK','dathd@gmail.com','Hoàng Duy Đạt','036511223344','0965188465','Thanh Xuân',1),(9,'vudh','$2a$10$EicNzjiam2QAqdzGLbLBFuJe27KIoA0mp9EISXyeWpHlea6YX/vy.','vhdh@gmail.com','Dương Hoàng Vũ','036433665588','0964887315','Tây Hồ',1),(10,'thaind','$2a$10$LJbr88Hq.xJz5OzqfojtYuaJBnTLagstIbk.mj1WzWpOiRNp3dYR2','thaind@gmail.com','Ngô Đăng Thái','065433116644','0967854312','Long Bien',1),(11,'chungnd','$2a$10$r5BzkLl5N8lYGmjLHthBx.wcqYdVZE4Gp5Jni4Gx0PndB2Zw0O0vG','chungnd@gmail.com','Nguyễn Đắc Chung','036499887766','0856433194','Bắc Từ Liêm',1),(12,'ducpv','$2a$10$F.nA5AkuuVLx65d.m7yi3uW7RoGsN1EHCyIbjGwreK2OMgDXStQi2','ducpv@gmail.com','Phạm Văn Đức','039655664488','0964315846','Hà Đông',1),(13,'hieudx1104@gmail.com','$2a$10$FCJXhMvKtXDHfUI/OeGfHOjLGFhI2rjYfjtW.gV7FlLZgTCfrdS52','hieudx1104@gmail.com','B18DCDT073 - Đỗ Xuân Hiếu','038012309187','0923012123','Bac Tu Liem',1),(14,'','$2a$10$tbeLKhoypuv7LqP6Mno0w.KDagbldMbWBhaGaq1GalcI5Dt1rGTF2','','',NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-24 18:20:12
