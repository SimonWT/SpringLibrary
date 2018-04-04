-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: eu-cdbr-west-02.cleardb.net    Database: heroku_f76d6fb9e659782
-- ------------------------------------------------------
-- Server version	5.6.38-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `articles`
--

DROP TABLE IF EXISTS `articles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articles` (
  `date` datetime DEFAULT NULL,
  `editors` varchar(255) DEFAULT NULL,
  `journal` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_a0fkyasvo48w0799xs3ksimke` FOREIGN KEY (`id`) REFERENCES `documents` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articles`
--

LOCK TABLES `articles` WRITE;
/*!40000 ALTER TABLE `articles` DISABLE KEYS */;
/*!40000 ALTER TABLE `articles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audio_video`
--

DROP TABLE IF EXISTS `audio_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `audio_video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `copies` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1241 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audio_video`
--

LOCK TABLES `audio_video` WRITE;
/*!40000 ALTER TABLE `audio_video` DISABLE KEYS */;
INSERT INTO `audio_video` VALUES (123,'KEK','KEK',123,123),(651,'null','av1',69,69),(661,'null','av1',69,69),(671,'null','av1',69,69),(681,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(691,'Claude Shannon','Information Entropy',0,1),(761,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(771,'Claude Shannon','Information Entropy',0,1),(781,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(791,'Claude Shannon','Information Entropy',0,1),(801,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(811,'Claude Shannon','Information Entropy',0,1),(821,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(831,'Claude Shannon','Information Entropy',0,1),(841,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(851,'Claude Shannon','Information Entropy',0,1),(861,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(871,'Claude Shannon','Information Entropy',0,1),(881,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(891,'Claude Shannon','Information Entropy',0,1),(901,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(911,'Claude Shannon','Information Entropy',0,1),(921,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(931,'Claude Shannon','Information Entropy',0,1),(941,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(951,'Claude Shannon','Information Entropy',0,1),(961,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(971,'Claude Shannon','Information Entropy',0,1),(981,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(991,'Claude Shannon','Information Entropy',0,1),(1001,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(1011,'Claude Shannon','Information Entropy',0,1),(1021,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(1031,'Claude Shannon','Information Entropy',0,1),(1041,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(1051,'Claude Shannon','Information Entropy',0,1),(1061,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(1071,'Claude Shannon','Information Entropy',0,1),(1081,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(1091,'Claude Shannon','Information Entropy',0,1),(1101,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(1111,'Claude Shannon','Information Entropy',0,1),(1121,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(1131,'Claude Shannon','Information Entropy',0,1),(1141,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(1151,'Claude Shannon','Information Entropy',0,1),(1161,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(1171,'Claude Shannon','Information Entropy',0,1),(1181,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(1191,'Claude Shannon','Information Entropy',0,1),(1201,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(1211,'Claude Shannon','Information Entropy',0,1),(1221,'Tony Hoare','Null References: The Billion Dollar Mistake',0,1),(1231,'Claude Shannon','Information Entropy',0,1);
/*!40000 ALTER TABLE `audio_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `av`
--

DROP TABLE IF EXISTS `av`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `av` (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_29wnlkgap66hevusn9li0oaql` FOREIGN KEY (`id`) REFERENCES `documents` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `av`
--

LOCK TABLES `av` WRITE;
/*!40000 ALTER TABLE `av` DISABLE KEYS */;
/*!40000 ALTER TABLE `av` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `year` varchar(255) NOT NULL,
  `edition` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `copies` int(11) NOT NULL,
  `bestSeller` bit(1) NOT NULL DEFAULT b'0',
  `checkoutDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1341 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (4,'Keksik','Teset','2999',9,9,9,'\0',NULL),(5,'How to break msturbate','Molly','01.2017',3,455,2,'\0',NULL),(11,'Test','Test','03/2018',3,2,4,'\0',NULL),(261,'Introduction to Algorithms','Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein','2009',3,0,3,'\0',NULL),(271,'Design Patterns: Elements of Reusable Object-Oriented Software','Erich Gamma, Ralph Johnson, John Vlissides, Richard Helm','2003',1,0,2,'\0',NULL),(281,'The Mythical Man-month','Brooks,Jr., Frederick P.','1995',2,0,1,'\0',NULL),(621,'Introduction to Algorithms','Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein','2009',3,0,3,'\0',NULL),(631,'Design Patterns: Elements of Reusable Object-Oriented Software','Erich Gamma, Ralph Johnson, John Vlissides, Richard Helm','2003',1,0,2,'\0',NULL),(641,'The Mythical Man-month','Brooks,Jr., Frederick P.','1995',2,0,1,'\0',NULL),(651,'Introduction to Algorithms','Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein','2009',3,0,3,'\0',NULL),(661,'Design Patterns: Elements of Reusable Object-Oriented Software','Erich Gamma, Ralph Johnson, John Vlissides, Richard Helm','2003',1,0,2,'\0',NULL),(671,'The Mythical Man-month','Brooks,Jr., Frederick P.','1995',2,0,1,'\0',NULL),(681,'Introduction to Algorithms','Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein','2009',3,0,3,'\0',NULL),(691,'Design Patterns: Elements of Reusable Object-Oriented Software','Erich Gamma, Ralph Johnson, John Vlissides, Richard Helm','2003',1,0,2,'\0',NULL),(701,'The Mythical Man-month','Brooks,Jr., Frederick P.','1995',2,0,1,'\0',NULL),(711,'Introduction to Algorithms','Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein','2009',3,0,3,'\0',NULL),(721,'Design Patterns: Elements of Reusable Object-Oriented Software','Erich Gamma, Ralph Johnson, John Vlissides, Richard Helm','2003',1,0,2,'\0',NULL),(731,'The Mythical Man-month','Brooks,Jr., Frederick P.','1995',2,0,1,'\0',NULL),(741,'Introduction to Algorithms','Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein','2009',3,0,3,'\0',NULL),(751,'Design Patterns: Elements of Reusable Object-Oriented Software','Erich Gamma, Ralph Johnson, John Vlissides, Richard Helm','2003',1,0,2,'\0',NULL),(761,'The Mythical Man-month','Brooks,Jr., Frederick P.','1995',2,0,1,'\0',NULL),(771,'Introduction to Algorithms','Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein','2009',3,0,3,'\0',NULL),(781,'Design Patterns: Elements of Reusable Object-Oriented Software','Erich Gamma, Ralph Johnson, John Vlissides, Richard Helm','2003',1,0,2,'\0',NULL),(791,'The Mythical Man-month','Brooks,Jr., Frederick P.','1995',2,0,1,'\0',NULL),(801,'Introduction to Algorithms','Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein','2009',3,0,3,'\0',NULL),(811,'Design Patterns: Elements of Reusable Object-Oriented Software','Erich Gamma, Ralph Johnson, John Vlissides, Richard Helm','2003',1,0,2,'\0',NULL),(821,'The Mythical Man-month','Brooks,Jr., Frederick P.','1995',2,0,1,'\0',NULL),(831,'Introduction to Algorithms','Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein','2009',3,0,3,'\0',NULL),(841,'Design Patterns: Elements of Reusable Object-Oriented Software','Erich Gamma, Ralph Johnson, John Vlissides, Richard Helm','2003',1,0,2,'\0',NULL),(851,'The Mythical Man-month','Brooks,Jr., Frederick P.','1995',2,0,1,'\0',NULL),(861,'Introduction to Algorithms','Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein','2009',3,0,3,'\0',NULL),(871,'Design Patterns: Elements of Reusable Object-Oriented Software','Erich Gamma, Ralph Johnson, John Vlissides, Richard Helm','2003',1,0,2,'\0',NULL),(891,'Introduction to Algorithms','Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein','2009',3,0,3,'\0',NULL),(901,'Design Patterns: Elements of Reusable Object-Oriented Software','Erich Gamma, Ralph Johnson, John Vlissides, Richard Helm','2003',1,0,2,'\0',NULL),(911,'The Mythical Man-month','Brooks,Jr., Frederick P.','1995',2,0,1,'\0',NULL),(921,'Introduction to Algorithms','Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein','2009',3,0,3,'\0',NULL),(931,'Design Patterns: Elements of Reusable Object-Oriented Software','Erich Gamma, Ralph Johnson, John Vlissides, Richard Helm','2003',1,0,2,'\0',NULL),(941,'The Mythical Man-month','Brooks,Jr., Frederick P.','1995',2,0,1,'\0',NULL),(951,'Introduction to Algorithms','null','null',3,0,3,'\0',NULL),(961,'Design Patterns: Elements of Reusable Object-Oriented Software','null','null',1,0,2,'\0',NULL),(971,'The Mythical Man-month','null','null',2,0,1,'\0',NULL),(981,'Introduction to Algorithms','null','null',3,0,3,'\0',NULL),(991,'Design Patterns: Elements of Reusable Object-Oriented Software','null','null',1,0,2,'\0',NULL),(1001,'The Mythical Man-month','null','null',2,0,1,'\0',NULL),(1011,'Introduction to Algorithms','null','null',3,0,3,'\0',NULL),(1021,'Design Patterns: Elements of Reusable Object-Oriented Software','null','null',1,0,2,'\0',NULL),(1031,'The Mythical Man-month','null','null',2,0,1,'\0',NULL),(1041,'Introduction to Algorithms','null','null',3,0,3,'\0',NULL),(1051,'Design Patterns: Elements of Reusable Object-Oriented Software','null','null',1,0,2,'\0',NULL),(1061,'The Mythical Man-month','null','null',2,0,1,'\0',NULL),(1071,'Introduction to Algorithms','null','null',3,0,3,'\0',NULL),(1081,'Design Patterns: Elements of Reusable Object-Oriented Software','null','null',1,0,2,'\0',NULL),(1091,'The Mythical Man-month','null','null',2,0,1,'\0',NULL),(1101,'Introduction to Algorithms','null','null',3,0,3,'\0',NULL),(1111,'Design Patterns: Elements of Reusable Object-Oriented Software','null','null',1,0,2,'\0',NULL),(1121,'The Mythical Man-month','null','null',2,0,1,'\0',NULL),(1131,'Introduction to Algorithms','null','null',3,0,3,'\0',NULL),(1141,'Design Patterns: Elements of Reusable Object-Oriented Software','null','null',1,0,2,'\0',NULL),(1151,'The Mythical Man-month','null','null',2,0,1,'\0',NULL),(1161,'Introduction to Algorithms','null','null',3,0,3,'\0',NULL),(1171,'Design Patterns: Elements of Reusable Object-Oriented Software','null','null',1,0,2,'\0',NULL),(1181,'The Mythical Man-month','null','null',2,0,1,'\0',NULL),(1191,'Introduction to Algorithms','null','null',3,0,3,'\0',NULL),(1201,'Design Patterns: Elements of Reusable Object-Oriented Software','null','null',1,0,2,'\0',NULL),(1211,'The Mythical Man-month','null','null',2,0,1,'\0',NULL),(1221,'Introduction to Algorithms','null','null',3,0,3,'\0',NULL),(1231,'Design Patterns: Elements of Reusable Object-Oriented Software','null','null',1,0,2,'\0',NULL),(1241,'The Mythical Man-month','null','null',2,0,1,'\0',NULL),(1251,'Introduction to Algorithms','null','null',3,0,3,'\0',NULL),(1261,'Design Patterns: Elements of Reusable Object-Oriented Software','null','null',1,0,2,'\0',NULL),(1271,'The Mythical Man-month','null','null',2,0,1,'\0',NULL),(1281,'Introduction to Algorithms','null','null',3,0,3,'\0',NULL),(1291,'Design Patterns: Elements of Reusable Object-Oriented Software','null','null',1,0,2,'\0',NULL),(1301,'The Mythical Man-month','null','null',2,0,1,'\0',NULL),(1311,'Introduction to Algorithms','null','null',3,0,3,'\0',NULL),(1321,'Design Patterns: Elements of Reusable Object-Oriented Software','null','null',1,0,2,'\0',NULL),(1331,'The Mythical Man-month','null','null',2,0,1,'\0',NULL);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books2`
--

DROP TABLE IF EXISTS `books2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books2` (
  `bestseller` bit(1) DEFAULT NULL,
  `edition` int(11) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `year` datetime DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_ln6d24bf98xmlc4a2djg53m2c` FOREIGN KEY (`id`) REFERENCES `documents` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books2`
--

LOCK TABLES `books2` WRITE;
/*!40000 ALTER TABLE `books2` DISABLE KEYS */;
INSERT INTO `books2` VALUES ('',1,'Keksik','2002-01-01 00:08:00',421);
/*!40000 ALTER TABLE `books2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documents`
--

DROP TABLE IF EXISTS `documents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `documents` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authors` varchar(255) DEFAULT NULL,
  `copies` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=431 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documents`
--

LOCK TABLES `documents` WRITE;
/*!40000 ALTER TABLE `documents` DISABLE KEYS */;
INSERT INTO `documents` VALUES (421,'SomeAuthor',4,16,'SomeBook');
/*!40000 ALTER TABLE `documents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `co_date` datetime DEFAULT NULL,
  `doc_id` bigint(20) DEFAULT NULL,
  `days_penalty` int(11) DEFAULT NULL,
  `ret_date` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `journal_articles`
--

DROP TABLE IF EXISTS `journal_articles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `journal_articles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `journal_title` varchar(255) NOT NULL,
  `article_title` varchar(255) NOT NULL,
  `publication_month_year` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `editor` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `copies` int(11) NOT NULL,
  `checkoutDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `journal_articles`
--

LOCK TABLES `journal_articles` WRITE;
/*!40000 ALTER TABLE `journal_articles` DISABLE KEYS */;
INSERT INTO `journal_articles` VALUES (1,'PlayBoyyy','Best Gay Actorrrr','3/2018','Zhenyok','Igor',1488,69,NULL);
/*!40000 ALTER TABLE `journal_articles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `queue`
--

DROP TABLE IF EXISTS `queue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `queue` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `doc_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `queue`
--

LOCK TABLES `queue` WRITE;
/*!40000 ALTER TABLE `queue` DISABLE KEYS */;
/*!40000 ALTER TABLE `queue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_USER'),(2,'ROLE_ADMIN');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `table_name`
--

DROP TABLE IF EXISTS `table_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `table_name` (
  `publisher` varchar(255) DEFAULT NULL,
  `edition` int(11) DEFAULT NULL,
  `year` year(4) DEFAULT NULL,
  `bestseller` tinyint(1) DEFAULT '0',
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `table_name_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_name`
--

LOCK TABLES `table_name` WRITE;
/*!40000 ALTER TABLE `table_name` DISABLE KEYS */;
/*!40000 ALTER TABLE `table_name` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_article`
--

DROP TABLE IF EXISTS `user_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_article` (
  `user_id` int(11) NOT NULL,
  `article_id` int(11) NOT NULL,
  KEY `user_id` (`user_id`),
  KEY `article_id` (`article_id`),
  CONSTRAINT `user_article_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `user_article_ibfk_2` FOREIGN KEY (`article_id`) REFERENCES `journal_articles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_article`
--

LOCK TABLES `user_article` WRITE;
/*!40000 ALTER TABLE `user_article` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_av`
--

DROP TABLE IF EXISTS `user_av`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_av` (
  `user_id` int(11) NOT NULL,
  `av_id` int(11) NOT NULL,
  KEY `user_id` (`user_id`),
  KEY `av_id` (`av_id`),
  CONSTRAINT `user_av_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `user_av_ibfk_2` FOREIGN KEY (`av_id`) REFERENCES `audio_video` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_av`
--

LOCK TABLES `user_av` WRITE;
/*!40000 ALTER TABLE `user_av` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_av` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_books`
--

DROP TABLE IF EXISTS `user_books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_books` (
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  KEY `user_id` (`user_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `user_books_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `user_books_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_books`
--

LOCK TABLES `user_books` WRITE;
/*!40000 ALTER TABLE `user_books` DISABLE KEYS */;
INSERT INTO `user_books` VALUES (71,5,'2018-06-03'),(31,11,'2018-07-03');
/*!40000 ALTER TABLE `user_books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_5q4rc4fh1on6567qk69uesvyf` (`role_id`),
  CONSTRAINT `FK_5q4rc4fh1on6567qk69uesvyf` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (31,1),(71,2),(3221,2);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `documents` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3711 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (31,'i.vakhula_user','$2a$11$KaBxQDYikh.EWsYw5Bo0B.6G7FYWZN2rVdelaZWT6.zDHXwlJCju6','Igor','Vakhula','89179232662','darklinhamb@gmail.com','Patron',NULL,NULL),(71,'DamskiyUgodnik','$2a$11$MQmxKWlWuYkDcPSaFS74I.rOa0GZndris3irnebhwPD4s0cuaauFi','Carvalio','Daniel','88005553535','kekdan@innopolis.ru','Librarian',NULL,NULL),(3221,'admin','$2a$11$gTmIhAY5BjLHS.ktd7T48e.TKou5IzqohJcDeloEpp6Uo/n0hYzHO','admin','admin','00000000000','innodeeplib@innopolis.ru','Librarian',NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_all`
--

DROP TABLE IF EXISTS `users_all`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_all` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_all`
--

LOCK TABLES `users_all` WRITE;
/*!40000 ALTER TABLE `users_all` DISABLE KEYS */;
INSERT INTO `users_all` VALUES (1,'admin','admin','admin','LIBRARIAN'),(2,'test','test','test','PATRON'),(11,'Sukka','Sukka','Sukka','PATRON'),(21,'Keksik','Keksik','Keksik','PATRON'),(31,'Libra','Libra','Libra','LIBRARIAN');
/*!40000 ALTER TABLE `users_all` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-04 13:27:56
