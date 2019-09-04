CREATE DATABASE IF NOT EXISTS escalade;

USE escalade;

CREATE TABLE Utilisateur (
                id_Utilisateur BIGINT NOT NULL AUTO_INCREMENT,
                nom VARCHAR(20) NOT NULL,
                adresseMail VARCHAR(100) NOT NULL,
                identifiant VARCHAR(50) NOT NULL,
                motDePasse VARCHAR(20) NOT NULL,
                dateInscription DATE NOT NULL,
                membreAssociation BOOLEAN NOT NULL,
                prenom VARCHAR(20) NOT NULL,
                ville VARCHAR(50) NOT NULL,
                pays VARCHAR(20) NOT NULL,

                PRIMARY KEY (id_Utilisateur),
                UNIQUE KEY (identifiant, adresseMail)
);


CREATE TABLE Topo (
                id_Topo BIGINT NOT NULL AUTO_INCREMENT,
                nom VARCHAR(20) NOT NULL,
                descriptions VARCHAR(300) NOT NULL,
                lieu VARCHAR(20) NOT NULL,
                dateParution DATE NOT NULL,
                disponible BOOLEAN NOT NULL,
                id_Utilisateur BIGINT NOT NULL,

                PRIMARY KEY (id_Topo),
                UNIQUE KEY (nom)
);



CREATE TABLE Sites (
                id_Site BIGINT NOT NULL AUTO_INCREMENT,
                nom VARCHAR(20) NOT NULL,
                hauteurMax INT NOT NULL,
                lieu VARCHAR(20) NOT NULL,
                taguerOfficiel BOOLEAN NOT NULL,
                descriptions VARCHAR(300) NOT NULL,
                rocher ENUM('Calcaire','Granite','Gneiss') NOT NULL,
                id_Topo BIGINT NOT NULL,

                PRIMARY KEY (id_Site),
                UNIQUE KEY (nom)
);


CREATE TABLE Secteur (
                id_Secteur BIGINT NOT NULL AUTO_INCREMENT,
                nom VARCHAR(20) NOT NULL,
                numeroSecteur INT NOT NULL,
                descriptions VARCHAR(300) NOT NULL,
                id_Sites BIGINT NOT NULL,

                PRIMARY KEY (id_Secteur),
                UNIQUE KEY (nom)
);


CREATE TABLE Voie (
                id_Voie BIGINT NOT NULL AUTO_INCREMENT,
                nom VARCHAR(20) NOT NULL,
                nombreLongueurs INT NOT NULL,
                equiperSpits BOOLEAN NOT NULL,
                cotation VARCHAR(20) NOT NULL,
                descriptions VARCHAR(300) NOT NULL,
                numeroVoie INT NOT NULL,
                id_Secteur BIGINT NOT NULL,

                PRIMARY KEY (id_Voie),
                UNIQUE KEY (nom)
);


CREATE TABLE Commentaire (
                id_Commentaire BIGINT NOT NULL AUTO_INCREMENT,
                texte VARCHAR(300) NOT NULL,
                date_du_commentaire DATE NOT NULL,
                id_Utilisateur BIGINT NOT NULL,
                id_Sites BIGINT NOT NULL,
                PRIMARY KEY (id_Commentaire)
);


ALTER TABLE Topo ADD CONSTRAINT utilisateur_topo_fk
FOREIGN KEY (id_Utilisateur)
REFERENCES Utilisateur (id_Utilisateur)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Commentaire ADD CONSTRAINT utilisateur_commentaire_fk
FOREIGN KEY (id_Utilisateur)
REFERENCES Utilisateur (id_Utilisateur)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Commentaire ADD CONSTRAINT sites_commentaire_fk
FOREIGN KEY (id_Sites)
REFERENCES Sites (id_Sites)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Secteur ADD CONSTRAINT sites_secteur_fk
FOREIGN KEY (id_Sites)
REFERENCES Sites (id_Sites)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Voie ADD CONSTRAINT secteur_voie_fk
FOREIGN KEY (id_Secteur)
REFERENCES Secteur (id_Secteur)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
