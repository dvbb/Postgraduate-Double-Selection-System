-- MySQL dump 10.13  Distrib 5.6.47, for Win64 (x86_64)
--
-- Host: localhost    Database: lyl
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
-- Table structure for table `choose`
--

DROP TABLE IF EXISTS `choose`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `choose` (
  `Sno` varchar(8) NOT NULL,
  `Tno` varchar(6) DEFAULT NULL,
  `Cno` int(2) NOT NULL,
  `status` int(1) NOT NULL,
  `wish` int(1) NOT NULL,
  PRIMARY KEY (`Sno`,`wish`),
  KEY `Tno` (`Tno`),
  KEY `Cno` (`Cno`),
  CONSTRAINT `choose_ibfk_1` FOREIGN KEY (`Sno`) REFERENCES `student` (`Sno`),
  CONSTRAINT `choose_ibfk_2` FOREIGN KEY (`Tno`) REFERENCES `teacher` (`Tno`),
  CONSTRAINT `choose_ibfk_3` FOREIGN KEY (`Cno`) REFERENCES `college` (`Cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `choose`
--

LOCK TABLES `choose` WRITE;
/*!40000 ALTER TABLE `choose` DISABLE KEYS */;
INSERT INTO `choose` VALUES ('20170001','t01006',1,2,2),('20170001','t01001',1,2,3),('20170002','t01001',1,2,1),('20170002','t01003',1,2,2),('20170002','t01006',1,2,3),('20170003','t01004',1,0,1),('20170003','t01001',1,2,2),('20170003','t01002',1,0,3),('20170004','t01010',1,0,1),('20170004','t01007',1,0,2),('20170004','t01001',1,0,3),('20170005','t01010',1,0,1),('20170005','t01002',1,0,2),('20170005','t01004',1,0,3),('20170006','t01007',1,0,1),('20170006','t01004',1,0,2),('20170006','t01002',1,0,3),('20170007','t01012',1,0,1),('20170007','t01007',1,0,2),('20170007','t01001',1,2,3),('20170008','t01010',1,0,1),('20170008','t01001',1,0,2);
/*!40000 ALTER TABLE `choose` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cmanager`
--

DROP TABLE IF EXISTS `cmanager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cmanager` (
  `Cmno` varchar(5) NOT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `Cmname` varchar(20) DEFAULT NULL,
  `Cno` int(2) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Cmno`),
  KEY `Cno` (`Cno`),
  CONSTRAINT `cmanager_ibfk_1` FOREIGN KEY (`Cno`) REFERENCES `college` (`Cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cmanager`
--

LOCK TABLES `cmanager` WRITE;
/*!40000 ALTER TABLE `cmanager` DISABLE KEYS */;
INSERT INTO `cmanager` VALUES ('c0101','123456','管泽',1,'18821502150'),('c0102','123456','管泽',1,'18821502150'),('c0103','123456','黄蜂',1,'18821502150'),('c0104','123456','樊璇',1,'18821502150');
/*!40000 ALTER TABLE `cmanager` ENABLE KEYS */;
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
INSERT INTO `college` VALUES (1,'计算机学院'),(2,'数理学院');
/*!40000 ALTER TABLE `college` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `Mno` varchar(4) NOT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Mno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES ('m001','123456','18821502150');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
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
  `email` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
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
INSERT INTO `student` VALUES ('20170001','天一','男',350,'上海交通大学','123456','软件工程','43962214@163.com','18821502150',1),('20170002','勾慧丽','女',350,'上海交通大学','123456','软件工程','43962214@163.com','18821502150',1),('20170003','荤楚云','女',350,'上海交通大学','123456','软件工程','43962214@163.com','18821502150',1),('20170004','茂承弼','男',350,'上海交通大学','123456','软件工程','43962214@163.com','18821502150',1),('20170005','律才俊','男',350,'上海交通大学','123456','软件工程','43962214@163.com','18821502150',1),('20170006','吉晴虹','女',350,'上海交通大学','123456','软件工程','43962214@163.com','18821502150',1),('20170007','秋新竹','女',350,'上海交通大学','123456','软件工程','43962214@163.com','18821502150',1),('20170008','揭凡雁','男',350,'上海交通大学','123456','软件工程','43962214@163.com','18821502150',1),('20170009','古手语','女',360,'上海商学院','123456','软件工程','lipin@163.com','18877002800',1),('20170188','阿德','男',350,'上海交通大学','123456','数理基础科学','43962214@163.com','18821502150',2),('20170189','焕琪','男',350,'上海交通大学','123456','数理基础科学','43962214@163.com','18821502150',2);
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
INSERT INTO `teacher` VALUES ('t01001','谭维','女','副教授',3,'一位好老师','123456','tweiwei@qq.com','软件工程',1),('t01002','隆采梦','女','副教授',3,'一位好老师','123','tweiwei@qq.com','软件工程',1),('t01003','耿专','女','副教授',3,'一位好老师','123','tweiwei@qq.com','软件工程',1),('t01004','慈初珍','女','副教授',3,'一位好老师','123','tweiwei@qq.com','软件工程',1),('t01005','庚芷天','女','教授',5,'计算机学院院长，国家一级院士','123','tweiwei@qq.com','软件工程',1),('t01006','禾翠柏','女','副教授',3,'一位好老师','123','tweiwei@qq.com','软件工程',1),('t01007','郜婷秀','男','副教授',3,'一位好老师','123','tweiwei@qq.com','软件工程',1),('t01008','谭弘济','男','副教授',3,'一位好老师','123','tweiwei@qq.com','软件工程',1),('t01009','谭合','男','副教授',3,'一位好老师','123','tweiwei@qq.com','软件工程',1),('t01010','覃和璧','男','副教授',3,'一位好老师','123','tweiwei@qq.com','软件工程',1),('t01011','功卉','女','副教授',3,'一位好老师','123','tweiwei@qq.com','软件工程',1),('t01012','闽琛丽','女','副教授',3,'一位好老师','123','tweiwei@qq.com','软件工程',1);
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

-- Dump completed on 2020-09-02 14:41:14
