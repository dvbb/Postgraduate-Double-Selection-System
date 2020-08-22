-- MySQL dump 10.13  Distrib 5.6.47, for Win64 (x86_64)
--
-- Host: localhost    Database: j2ee
-- ------------------------------------------------------
-- Server version	5.6.47

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
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrator` (
  `Ano` varchar(4) NOT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Ano`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES ('ad01','000'),('ad02','000');
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cadmini`
--

DROP TABLE IF EXISTS `cadmini`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cadmini` (
  `CAno` varchar(5) NOT NULL DEFAULT '',
  `pwd` varchar(20) DEFAULT NULL,
  `CAname` varchar(20) DEFAULT NULL,
  `Cno` int(2) DEFAULT NULL,
  PRIMARY KEY (`CAno`),
  KEY `Cno` (`Cno`),
  CONSTRAINT `cadmini_ibfk_1` FOREIGN KEY (`Cno`) REFERENCES `college` (`Cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadmini`
--

LOCK TABLES `cadmini` WRITE;
/*!40000 ALTER TABLE `cadmini` DISABLE KEYS */;
INSERT INTO `cadmini` VALUES ('c0101','000','管仪',1),('c0102','5787','管仲',1),('c0201','000','路迩',1);
/*!40000 ALTER TABLE `cadmini` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `choose`
--

DROP TABLE IF EXISTS `choose`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `choose` (
  `Sno` varchar(8) NOT NULL,
  `Tno` varchar(6) NOT NULL DEFAULT '',
  `Cno` int(2) NOT NULL,
  `status` int(1) NOT NULL,
  PRIMARY KEY (`Sno`,`Tno`),
  KEY `Cno` (`Cno`),
  KEY `Tno` (`Tno`),
  CONSTRAINT `choose_ibfk_1` FOREIGN KEY (`Cno`) REFERENCES `college` (`Cno`),
  CONSTRAINT `choose_ibfk_2` FOREIGN KEY (`Sno`) REFERENCES `student` (`Sno`),
  CONSTRAINT `choose_ibfk_3` FOREIGN KEY (`Tno`) REFERENCES `teacher` (`Tno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `choose`
--

LOCK TABLES `choose` WRITE;
/*!40000 ALTER TABLE `choose` DISABLE KEYS */;
INSERT INTO `choose` VALUES ('20170001','t01001',1,2),('20170002','t01002',1,1),('20170003','t01003',1,1),('20170003','t01006',1,1),('20170003','t01007',1,1),('20170004','t01003',1,1),('20170004','t01004',1,1),('20170004','t01005',1,2),('20170005','t01004',1,1),('20170005','t01005',1,1),('20170006','t01003',1,1),('20170006','t01005',1,1),('20170006','t01007',1,1),('20170057','t02001',2,1);
/*!40000 ALTER TABLE `choose` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `college`
--

DROP TABLE IF EXISTS `college`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `college` (
  `Cno` int(2) NOT NULL,
  `Cname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `college`
--

LOCK TABLES `college` WRITE;
/*!40000 ALTER TABLE `college` DISABLE KEYS */;
INSERT INTO `college` VALUES (1,'计算机学院'),(2,'外国语学院');
/*!40000 ALTER TABLE `college` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `Sno` varchar(8) NOT NULL,
  `Sname` varchar(20) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `grade` int(30) DEFAULT NULL,
  `school` varchar(30) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `discipline` varchar(20) DEFAULT NULL,
  `Cno` int(2) DEFAULT NULL,
  PRIMARY KEY (`Sno`),
  KEY `Cno` (`Cno`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`Cno`) REFERENCES `college` (`Cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('20170001','路频','男',343,'上海商学院','000','软件工程',1),('20170002','李四','女',420,'上海商学院','5787606','软件工程',1),('20170003','蒋昌理','女',347,'上海政法大学','123','网络安全',1),('20170004','李四','女',357,'上海海洋大学','123','网络安全',1),('20170005','王亚','女',357,'上海海洋大学','123','网络安全',1),('20170006','钱胜','男',357,'上海海洋大学','123','网络安全',1),('20170007','王强','女',357,'上海海洋大学','123','网络安全',1),('20170008','张章','男',357,'上海海洋大学','123','网络安全',1),('20170009','蒋理','女',347,'上海政法大学','123','网络安全',1),('20170057','李城','女',337,'上海海洋大学','123','英语专业',2),('20170058','李想','女',337,'上海海洋大学','123','英语专业',2),('20170059','李亿','女',337,'上海海洋大学','123','英语专业',2),('20170060','李达','女',337,'上海海洋大学','123','英语专业',2);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `Tno` varchar(6) NOT NULL DEFAULT '',
  `Tname` varchar(20) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `leadnum` int(2) DEFAULT NULL,
  `intro` varchar(200) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `discipline` varchar(20) DEFAULT NULL,
  `Cno` int(2) DEFAULT NULL,
  PRIMARY KEY (`Tno`),
  KEY `Cno` (`Cno`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`Cno`) REFERENCES `college` (`Cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES ('t01001','郑思为','男','副教授',3,'计算机学院副院长，国家一级院士','000541','zensiwei@163.com','软件工程',1),('t01002','李萍','女','教授',3,'计算机学院院长，国家一级院士','123547','lipin@163.com','软件工程',1),('t01003','李兴','女','副教授',3,'博士学位，长期从事科研和项目开发','123','tweiwei@qq.com','网络安全',1),('t01004','谭维','女','副教授',3,'博士学位，长期从事科研和项目开发','123','tweiwei@qq.com','网络安全',1),('t01005','魏成','男','副教授',3,'博士学位，长期从事科研和项目开发','123','tweiwei@qq.com','网络安全',1),('t01006','钱学曾','男','副教授',3,'博士学位，长期从事科研和项目开发','123','tweiwei@qq.com','网络安全',1),('t01007','曾一番','男','副教授',3,'博士学位，长期从事科研和项目开发','123','tweiwei@qq.com','网络安全',1),('t02001','欧成','男','副教授',3,'博士学位，主攻英美文学','123','toucheng@qq.com','英语专业',2),('t02002','李斯','男','副教授',3,'博士学位，主攻英美文学','123','toucheng@qq.com','英语专业',2);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-29 11:27:48
