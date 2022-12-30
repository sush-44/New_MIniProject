-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: miniproject
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `UserId` varchar(15) NOT NULL,
  `Password` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('bhalchandra','12345'),('datta','datta'),('ganesh123','ganesh123'),('raj','1234'),('sdc','sdcv'),('shubham','123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `javastudent`
--

DROP TABLE IF EXISTS `javastudent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `javastudent` (
  `Roll_num` int NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Marks` int DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Roll_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `javastudent`
--

LOCK TABLES `javastudent` WRITE;
/*!40000 ALTER TABLE `javastudent` DISABLE KEYS */;
INSERT INTO `javastudent` VALUES (1,'shubham',10,'A'),(2,'harsh',7,'B'),(5,'5',10,'A'),(12,'disha',1,'Fail');
/*!40000 ALTER TABLE `javastudent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `queopt`
--

DROP TABLE IF EXISTS `queopt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `queopt` (
  `queNo` int NOT NULL,
  `que` varchar(200) DEFAULT NULL,
  `option1` varchar(200) DEFAULT NULL,
  `option2` varchar(200) DEFAULT NULL,
  `option3` varchar(200) DEFAULT NULL,
  `option4` varchar(200) DEFAULT NULL,
  `answerkey` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`queNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `queopt`
--

LOCK TABLES `queopt` WRITE;
/*!40000 ALTER TABLE `queopt` DISABLE KEYS */;
INSERT INTO `queopt` VALUES (1,'Who founded Java Programming?','a. Guido van Rossum','b.James Gosling','c. Dennis Ritchie','d. Bjarne Stroustrup','b'),(2,'What part is used to compile, debug and execute java programs?','a. JRE','b.JIT','c. JDK','d. JVM','c'),(3,'Which of these selection statements in Java do you have?','a.a break','b.continue','c.for()','d.if()','d'),(4,'Which of these statements are wrong about Thread?','a. start () method is used to start a thread function','b.run () method is used to start a thread process before start the () method in special cases','c. The thread can be created using only the runnable interface','d. The thread can be made of a class that extends to the Thread class','b'),(5,'Which of these keywords is used to block an exception?','a. check','b.throw','c. catch','d. try','d'),(6,'Which of the following is not an access modifier?','a. Protected','b.Void','c. Public','d. Confidential','b'),(7,'Where does the system stores parameters and local variables whenever a method is invoked?','a.Heap','b.Stack','c.Array','d.Tree','b'),(8,'When is the finalize() method called?','a. Before Garbage Collection','b.Before an object goes out of scope','c. Before a variable goes out of scope','d. None','a'),(9,'What is Runnable?','a. Abstract class','b.Interface','c. Class','d. Method','b'),(10,' Which of these packages contains the stack overflow variant in Java?','a. java.io','b.java.system','c. java.lang','d. java.util','c');
/*!40000 ALTER TABLE `queopt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'miniproject'
--
/*!50003 DROP PROCEDURE IF EXISTS `Grade` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Grade`()
BEGIN
update javastudent set grade='A' where marks>=8 and marks<=10;
update javastudent set grade='B' where marks>=6 and marks<=7;
update javastudent set grade='C' where marks=5 ;
update javastudent set grade='Fail' where marks<5;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-22 16:40:06
