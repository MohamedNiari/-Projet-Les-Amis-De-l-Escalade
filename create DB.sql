CREATE DATABASE `escalade` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE escalade;

CREATE TABLE `utilisateur` (
  `id_Utilisateur` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `adresseMail` varchar(100) NOT NULL,
  `identifiant` varchar(50) NOT NULL,
  `motDePasse` varchar(20) NOT NULL,
  `dateInscription` date NOT NULL,
  `membreAssociation` tinyint(1) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `pays` varchar(20) NOT NULL,
  PRIMARY KEY (`id_Utilisateur`),
  UNIQUE KEY `identifiant` (`identifiant`,`adresseMail`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `topo` (
  `id_Topo` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `lieu` varchar(20) NOT NULL,
  `dateParution` date NOT NULL,
  `disponible` tinyint(1) NOT NULL,
  `id_Utilisateur` bigint(20),
  PRIMARY KEY (`id_Topo`),
  UNIQUE KEY `nom` (`nom`),
  KEY `utilisateur_topo_fk` (`id_Utilisateur`),
  CONSTRAINT `utilisateur_topo_fk` FOREIGN KEY (`id_Utilisateur`) REFERENCES `utilisateur` (`id_Utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `site` (
  `id_Site` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `hauteurMax` int(11) NOT NULL,
  `lieu` varchar(20) NOT NULL,
  `taguerOfficiel` tinyint(1) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `rocher` enum('Calcaire','Granite','Gneiss') NOT NULL,
  `url_Image` varchar(300),
  `id_Topo` bigint(20),
  PRIMARY KEY (`id_Site`),
  UNIQUE KEY `nom` (`nom`),
  KEY `topo_site_fk` (`id_Topo`),
  CONSTRAINT `topo_site_fk` FOREIGN KEY (`id_Topo`) REFERENCES `topo` (`id_Topo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `commentaire` (
  `id_Commentaire` bigint(20) NOT NULL AUTO_INCREMENT,
  `texte` varchar(300) NOT NULL,
  `date_du_commentaire` date NOT NULL,
  `id_Utilisateur` bigint(20),
  `id_Site` bigint(20),
  PRIMARY KEY (`id_Commentaire`),
  KEY `utilisateur_commentaire_fk` (`id_Utilisateur`),
  KEY `site_commentaire_fk` (`id_Site`),
  CONSTRAINT `site_commentaire_fk` FOREIGN KEY (`id_Site`) REFERENCES `site` (`id_Site`),
  CONSTRAINT `utilisateur_commentaire_fk` FOREIGN KEY (`id_Utilisateur`) REFERENCES `utilisateur` (`id_Utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `secteur` (
  `id_Secteur` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `numeroSecteur` int(11) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `id_Site` bigint(20),
  PRIMARY KEY (`id_Secteur`),
  UNIQUE KEY `nom` (`nom`),
  KEY `site_secteur_fk` (`id_Site`),
  CONSTRAINT `site_secteur_fk` FOREIGN KEY (`id_Site`) REFERENCES `site` (`id_Site`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `voie` (
  `id_Voie` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `nombreLongueurs` int(11) NOT NULL,
  `equiperSpits` tinyint(1) NOT NULL,
  `cotation` varchar(20) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `numeroVoie` int(11) NOT NULL,
  `id_Secteur` bigint(20),
  PRIMARY KEY (`id_Voie`),
  UNIQUE KEY `nom` (`nom`),
  KEY `secteur_voie_fk` (`id_Secteur`),
  CONSTRAINT `secteur_voie_fk` FOREIGN KEY (`id_Secteur`) REFERENCES `secteur` (`id_Secteur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




