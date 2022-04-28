-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: labsd
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `user_residence_document`
--

DROP TABLE IF EXISTS `user_residence_document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_residence_document` (
  `id` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `request` int NOT NULL,
  `document_id` varchar(255) NOT NULL,
  `user_residence_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKju5n6dpqponwbn5ah1b3if310` (`document_id`),
  KEY `FK97f38e6tx7i1ayygyg039bsri` (`user_residence_id`),
  CONSTRAINT `FK97f38e6tx7i1ayygyg039bsri` FOREIGN KEY (`user_residence_id`) REFERENCES `user_residence` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKju5n6dpqponwbn5ah1b3if310` FOREIGN KEY (`document_id`) REFERENCES `document` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_residence_document`
--

LOCK TABLES `user_residence_document` WRITE;
/*!40000 ALTER TABLE `user_residence_document` DISABLE KEYS */;
INSERT INTO `user_residence_document` VALUES ('c1fc3b29-1bc8-42b9-a0bb-d43c868a89e7','2022-03-23',0,'01f6a91b-0716-4933-a430-7d5e1720041a','07665a2e-4535-4922-ae45-98bfe7d8c1ef');
/*!40000 ALTER TABLE `user_residence_document` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-24  2:16:38
