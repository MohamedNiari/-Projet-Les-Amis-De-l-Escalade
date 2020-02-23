CREATE DATABASE  IF NOT EXISTS `escalade` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `escalade`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: escalade
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commentaire` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_du_commentaire` varchar(255) DEFAULT NULL,
  `texte` varchar(255) DEFAULT NULL,
  `site_id` bigint(20) DEFAULT NULL,
  `utilisateur_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcx7t4xq1u5p2n14eua8oksi75` (`site_id`),
  KEY `FKb7i29ppss6dbhwjihif0x2sg6` (`utilisateur_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commentaire`
--

LOCK TABLES `commentaire` WRITE;
/*!40000 ALTER TABLE `commentaire` DISABLE KEYS */;
/*!40000 ALTER TABLE `commentaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `longueur`
--

DROP TABLE IF EXISTS `longueur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `longueur` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cotation` varchar(255) DEFAULT NULL,
  `equiper_spits` bit(1) DEFAULT NULL,
  `mesure` int(11) DEFAULT NULL,
  `numero_longueur` int(11) DEFAULT NULL,
  `voie_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6ynbttxoapqb7kupip9jb2hbh` (`voie_id`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `longueur`
--

LOCK TABLES `longueur` WRITE;
/*!40000 ALTER TABLE `longueur` DISABLE KEYS */;
INSERT INTO `longueur` VALUES (1,'6a',_binary '\0',49,8,1),(2,'4a',_binary '',25,1,1),(3,'5c',_binary '\0',15,2,1),(4,'5b',_binary '',41,3,1),(5,'4c',_binary '',35,4,1),(6,'5a',_binary '',25,5,1),(7,'5c',_binary '\0',12,6,1),(8,'5a',_binary '\0',14,7,1),(9,'7a',_binary '',45,1,2),(10,'7c',_binary '\0',14,2,2),(11,'8a',_binary '\0',25,3,2),(12,'8b',_binary '',32,4,2),(13,'8c',_binary '\0',21,1,3),(14,'7b',_binary '\0',18,2,3),(15,'7a',_binary '\0',45,3,3),(16,'6c',_binary '',14,4,3),(17,'8a',_binary '\0',25,5,3),(18,'6c',_binary '\0',32,6,3),(19,'7a',_binary '',21,1,4),(20,'7b',_binary '',11,2,4),(21,'5c',_binary '',25,3,4),(22,'6b',_binary '\0',17,4,4),(23,'6c',_binary '',14,5,4),(24,'7a',_binary '',29,6,4),(25,'6c',_binary '',4,7,4),(26,'6a',_binary '\0',49,8,4),(27,'9c',_binary '\0',10,1,7),(28,'5c',_binary '\0',17,1,8);
/*!40000 ALTER TABLE `longueur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prenoms`
--

DROP TABLE IF EXISTS `prenoms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prenoms` (
  `utilisateur_id` bigint(20) NOT NULL,
  `prenoms` varchar(255) DEFAULT NULL,
  KEY `FKlnwx2qthb2f7i812hkbi0pym0` (`utilisateur_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenoms`
--

LOCK TABLES `prenoms` WRITE;
/*!40000 ALTER TABLE `prenoms` DISABLE KEYS */;
INSERT INTO `prenoms` VALUES (1,'Mohamed'),(1,'James'),(1,'Tayeb'),(2,'Lauren');
/*!40000 ALTER TABLE `prenoms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `accepter` bit(1) DEFAULT NULL,
  `proprietaire_id` bigint(20) DEFAULT NULL,
  `topo_id` bigint(20) DEFAULT NULL,
  `utilisateur_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKowe0gpe7f78y6fkb7ytuao03w` (`proprietaire_id`),
  KEY `FKkb2wyhq39jwa4g4mkwahbgc00` (`topo_id`),
  KEY `FK4nwqhu93pf8ky3819c0eike26` (`utilisateur_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (1,_binary '',1,1,2),(2,_binary '\0',2,2,1);
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secteur`
--

DROP TABLE IF EXISTS `secteur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `secteur` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `numero_secteur` int(11) DEFAULT NULL,
  `site_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo99reeujpc22wxdnvxfx8r5rq` (`site_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secteur`
--

LOCK TABLES `secteur` WRITE;
/*!40000 ALTER TABLE `secteur` DISABLE KEYS */;
INSERT INTO `secteur` VALUES (1,'Enormes cannelures','La vertical',1,1),(2,'Son calcaire est superbe et unique','Saint-Georges',2,1),(3,'Le rocher est finement sculpté ','Autracien',3,1),(4,'Très patinée','Himalaya',1,4),(5,'Des lignes très abordables','Pic',2,4),(6,'bleu','bleu',1,5),(7,'bleu','bleu',1,6);
/*!40000 ALTER TABLE `secteur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site`
--

DROP TABLE IF EXISTS `site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `site` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(500) DEFAULT NULL,
  `hauteur_max` int(11) DEFAULT NULL,
  `lieu` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `taguer_officiel` bit(1) DEFAULT NULL,
  `type_rocher` varchar(255) DEFAULT NULL,
  `utilisateur_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2a1efp3jjx9wpjdab4y2k67vs` (`utilisateur_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site`
--

LOCK TABLES `site` WRITE;
/*!40000 ALTER TABLE `site` DISABLE KEYS */;
INSERT INTO `site` VALUES (1,'Pas beaucoup de voies pour l’instant mais il y a encore un peu de potentiel, il est donc probable que de nouvelles voies soient équipées, voire d’autres secteurs.',42,'Privas','Bellevue',_binary '\0','Granite',1),(2,'C’est LA FALAISE incontournable de la région par sa taille, sa grimpe et sa vue. Son orientation ouest, et le peu d’ombre au pied de la falaise, font que l’on peut y grimper toute l’année.',74,'Thorens','Ablon',_binary '','Gneiss',1),(3,'Site à la mode dans les années 1970 pour aller taquiner du piton, le Teillon aujourd’hui ne parle plus à personne, éclipsé qu’il est dans l’ombre médiatique et photogénique de sa célébrissime voisine.',69,'Oullins','Le Teillon',_binary '','Calcaire',2),(4,'À quelques kilomètres au Sud de Dijon, la falaise de Fixin surplombe le fameux vignoble bourguignon, réputé mondialement pour ses grands crus dont le célèbre cépage pousse à merveille sur les sous-sols calcaires du coin.',21,'Dijon','Fixin',_binary '\0','Granite',2),(5,'bleu',35,'bleu','bleu',_binary '\0','Calcaire',2),(6,'bleu',87,'bleu','bleu1',_binary '\0','Calcaire',2);
/*!40000 ALTER TABLE `site` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site_commentaire`
--

DROP TABLE IF EXISTS `site_commentaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `site_commentaire` (
  `Site_site_id` bigint(20) NOT NULL,
  `commentaires_commentaire_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_khg4xf9ksglgaawmkp538f5pc` (`commentaires_commentaire_id`),
  KEY `FKh9ticyc98fy7c11ops7xm7yks` (`Site_site_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site_commentaire`
--

LOCK TABLES `site_commentaire` WRITE;
/*!40000 ALTER TABLE `site_commentaire` DISABLE KEYS */;
/*!40000 ALTER TABLE `site_commentaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site_url_image`
--

DROP TABLE IF EXISTS `site_url_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `site_url_image` (
  `site_id` bigint(20) NOT NULL,
  `url_image` varchar(255) DEFAULT NULL,
  KEY `FKmr2d2gh3pec175q715t0itnto` (`site_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site_url_image`
--

LOCK TABLES `site_url_image` WRITE;
/*!40000 ALTER TABLE `site_url_image` DISABLE KEYS */;
INSERT INTO `site_url_image` VALUES (1,'img/Ablon.jpg'),(1,'img/Ablon2.jpg'),(1,'img/Ablon3.jpg'),(2,'img/Bellevue.jpg'),(2,'img/Bellevue2.png'),(2,'img/Bellevue3.png'),(3,'img/LeTeillon.jpg'),(3,'img/LeTeillon2.jpg'),(3,'img/LeTeillon3.jpg'),(4,'img/Fixin.png'),(4,'img/Fixin2.png'),(4,'img/Fixin3.png');
/*!40000 ALTER TABLE `site_url_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topo`
--

DROP TABLE IF EXISTS `topo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_parution` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `disponible` bit(1) DEFAULT NULL,
  `lieu` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `utilisateur_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7jnb0511aod2q06sg3seytggp` (`utilisateur_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topo`
--

LOCK TABLES `topo` WRITE;
/*!40000 ALTER TABLE `topo` DISABLE KEYS */;
INSERT INTO `topo` VALUES (1,'04 Septembre 2015','Rive gauche, le rocher passe à l’ombre à 12h30 mais les arbres cachent assez bien le soleil avant. On peut donc y grimper en été, même le matin hors période de canicule.',_binary '','La Savoie','Escalade en Savoie',1),(2,'04 février 2020','L\'escalade développe de nombreuses qualités physiques, comme la force musculaire, la souplesse, l\'endurance musculaire, l\'équilibre, de bonnes capacités psychomotrices et de planification. Elle sollic',_binary '','Orleanais','Multisite',2);
/*!40000 ALTER TABLE `topo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topo_site`
--

DROP TABLE IF EXISTS `topo_site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topo_site` (
  `topo_id` bigint(20) NOT NULL,
  `site_id` bigint(20) NOT NULL,
  KEY `FKmj02u77qv3rgj68vu2fl6uc5a` (`site_id`),
  KEY `FKionbr8hpflb4k7a34w0d2m9wg` (`topo_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topo_site`
--

LOCK TABLES `topo_site` WRITE;
/*!40000 ALTER TABLE `topo_site` DISABLE KEYS */;
INSERT INTO `topo_site` VALUES (2,3),(2,4),(2,5),(2,6);
/*!40000 ALTER TABLE `topo_site` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utilisateur` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adresse_mail` varchar(255) DEFAULT NULL,
  `date_inscription` varchar(255) DEFAULT NULL,
  `membre_association` bit(1) DEFAULT NULL,
  `mot_de_passe` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `pays` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur`
--

LOCK TABLES `utilisateur` WRITE;
/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
INSERT INTO `utilisateur` VALUES (1,'mniari@openclassroom.com','04/09/2019',_binary '','bonjour','Niari','France','Sochaux'),(2,'lsmith@openclassroom.com','14/12/2019',_binary '\0','bonjour','Smith','Suisse','Berne');
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilisateur_topo`
--

DROP TABLE IF EXISTS `utilisateur_topo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utilisateur_topo` (
  `Utilisateur_utilisateur_id` bigint(20) NOT NULL,
  `topos_topo_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_31yotc2aou3jvpwcgaram984c` (`topos_topo_id`),
  KEY `FKdbryiv1t4dyubwck4lwyof9yo` (`Utilisateur_utilisateur_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur_topo`
--

LOCK TABLES `utilisateur_topo` WRITE;
/*!40000 ALTER TABLE `utilisateur_topo` DISABLE KEYS */;
/*!40000 ALTER TABLE `utilisateur_topo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voie`
--

DROP TABLE IF EXISTS `voie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre_longueur` int(11) DEFAULT NULL,
  `numero_voie` int(11) DEFAULT NULL,
  `secteur_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdkri2vygcek6r4nb4lf601mjm` (`secteur_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voie`
--

LOCK TABLES `voie` WRITE;
/*!40000 ALTER TABLE `voie` DISABLE KEYS */;
INSERT INTO `voie` VALUES (1,7,1,1),(2,4,2,1),(3,6,3,1),(4,8,4,1),(5,4,1,2),(6,5,2,2),(7,1,1,6),(8,1,1,7);
/*!40000 ALTER TABLE `voie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-23 21:12:35
