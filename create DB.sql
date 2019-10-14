CREATE DATABASE `escalade` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE escalade;

CREATE TABLE `utilisateur` (
  `utilisateur_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `adresse_mail` varchar(100) NOT NULL,
  `identifiant` varchar(50) NOT NULL,
  `mot_de_passe` varchar(20) NOT NULL,
  `date_inscription` date NOT NULL,
  `membre_association` tinyint(1) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `pays` varchar(20) NOT NULL,
  PRIMARY KEY (`utilisateur_id`),
  UNIQUE KEY `identifiant` (`identifiant`,`adresse_mail`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `topo` (
  `topo_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `lieu` varchar(20) NOT NULL,
  `date_parution` date NOT NULL,
  `disponible` tinyint(1) NOT NULL,
  `utilisateur_id` bigint(20),
  PRIMARY KEY (`topo_id`),
  UNIQUE KEY `nom` (`nom`),
  KEY `utilisateur_topo_fk` (`utilisateur_id`),
  CONSTRAINT `utilisateur_topo_fk` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`utilisateur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `site` (
  `site_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `hauteur_max` int(11) NOT NULL,
  `lieu` varchar(20) NOT NULL,
  `taguer_officiel` tinyint(1) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `rocher` enum('Calcaire','Granite','Gneiss') NOT NULL,
  `url_image` varchar(300),
  `topo_id` bigint(20),
  PRIMARY KEY (`site_id`),
  UNIQUE KEY `nom` (`nom`),
  KEY `topo_site_fk` (`topo_id`),
  CONSTRAINT `topo_site_fk` FOREIGN KEY (`topo_id`) REFERENCES `topo` (`topo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `commentaire` (
  `commentaire_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `texte` varchar(300) NOT NULL,
  `date_du_commentaire` date NOT NULL,
  `utilisateur_id` bigint(20),
  `site_id` bigint(20),
  PRIMARY KEY (`commentaire_id`),
  KEY `utilisateur_commentaire_fk` (`utilisateur_id`),
  KEY `site_commentaire_fk` (`site_id`),
  CONSTRAINT `site_commentaire_fk` FOREIGN KEY (`site_id`) REFERENCES `site` (`site_id`),
  CONSTRAINT `utilisateur_commentaire_fk` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`utilisateur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `secteur` (
  `secteur_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `numero_secteur` int(11) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `site_id` bigint(20),
  PRIMARY KEY (`secteur_id`),
  UNIQUE KEY `nom` (`nom`),
  KEY `site_secteur_fk` (`site_id`),
  CONSTRAINT `site_secteur_fk` FOREIGN KEY (`site_id`) REFERENCES `site` (`site_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `voie` (
  `voie_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `nombre_longueur` int(11) NOT NULL,
  `equiper_spits` tinyint(1) NOT NULL,
  `cotation` varchar(20) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `numero_voie` int(11) NOT NULL,
  `secteur_id` bigint(20),
  PRIMARY KEY (`voie_id`),
  UNIQUE KEY `nom` (`nom`),
  KEY `secteur_voie_fk` (`secteur_id`),
  CONSTRAINT `secteur_voie_fk` FOREIGN KEY (`secteur_id`) REFERENCES `secteur` (`secteur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




