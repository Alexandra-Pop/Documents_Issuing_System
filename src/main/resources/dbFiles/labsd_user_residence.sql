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
-- Table structure for table `user_residence`
--

DROP TABLE IF EXISTS `user_residence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_residence` (
  `id` varchar(255) NOT NULL,
  `residence_id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKswa65pafr0ouqt1nn99i5kdjy` (`user_id`),
  KEY `FK5je6eeraf502wd1rnqaroc2vp` (`residence_id`),
  CONSTRAINT `FK5je6eeraf502wd1rnqaroc2vp` FOREIGN KEY (`residence_id`) REFERENCES `residence` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKswa65pafr0ouqt1nn99i5kdjy` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_residence`
--

LOCK TABLES `user_residence` WRITE;
/*!40000 ALTER TABLE `user_residence` DISABLE KEYS */;
INSERT INTO `user_residence` VALUES ('07665a2e-4535-4922-ae45-98bfe7d8c1ef','222b62af-77f0-4c3d-83f6-275d9c57e448','e356cdb0-f4c4-43f9-906a-f300e193d161'),('88ac1667-42a6-4e35-9c48-5491ece25408','27aa9a8a-abc6-4271-92c2-a2685dac32d3','e356cdb0-f4c4-43f9-906a-f300e193d161'),('e73b82d5-e3ec-4316-a902-327ad5fdb072','c0530d8d-f684-4c58-ba33-2e37e2c7fe42','e356cdb0-f4c4-43f9-906a-f300e193d161');
/*!40000 ALTER TABLE `user_residence` ENABLE KEYS */;
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
