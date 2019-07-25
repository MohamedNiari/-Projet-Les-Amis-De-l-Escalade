
CREATE TABLE Utilisateur (
                id_Utilisateur INT NOT NULL,
                nom VARCHAR NOT NULL,
                adresseMail VARCHAR NOT NULL,
                identifiant VARCHAR NOT NULL,
                motDePasse VARCHAR NOT NULL,
                dateInscription DATE NOT NULL,
                membreAssociation BOOLEAN NOT NULL,
                prenom VARCHAR NOT NULL,
                ville VARCHAR NOT NULL,
                pays VARCHAR NOT NULL,
                PRIMARY KEY (id_Utilisateur)
);


CREATE TABLE Topo (
                id_Topo INT NOT NULL,
                nom VARCHAR NOT NULL,
                descriptions VARCHAR NOT NULL,
                lieu VARCHAR NOT NULL,
                dateParution DATE NOT NULL,
                sites ARRAYLIST<Sites> NOT NULL,
                disponible BOOLEAN NOT NULL,
                proprietaire Utilisateur.nom NOT NULL,
                id_Utilisateur INT NOT NULL,
                PRIMARY KEY (id_Topo)
);


CREATE TABLE Sites (
                id_Sites INT NOT NULL,
                nom VARCHAR NOT NULL,
                hauteurMax INT NOT NULL,
                lieu VARCHAR NOT NULL,
                taguerOfficiel BOOLEAN NOT NULL,
                descriptions VARCHAR NOT NULL,
                rocher ENUM('Calcaire','Granite','Gneiss') NOT NULL,
                secteur Secteur ARRAY NOT NULL,
                PRIMARY KEY (id_Sites)
);


CREATE TABLE Secteur (
                id_Secteur INT NOT NULL,
                nom VARCHAR NOT NULL,
                voie ARRAY NOT NULL,
                numeroSecteur INT NOT NULL,
                descriptions VARCHAR NOT NULL,
                id_Sites INT NOT NULL,
                PRIMARY KEY (id_Secteur)
);


CREATE TABLE Voie (
                id_Voie INT NOT NULL,
                nom VARCHAR NOT NULL,
                nombreLongueurs INT NOT NULL,
                equiperSpits BOOLEAN NOT NULL,
                cotation VARCHAR NOT NULL,
                descriptions VARCHAR NOT NULL,
                numeroVoie INT NOT NULL,
                id_Secteur INT NOT NULL,
                PRIMARY KEY (id_Voie)
);


CREATE TABLE Commentaire (
                id_Commentaire INT NOT NULL,
                nom OTHER NOT NULL,
                texte VARCHAR NOT NULL,
                date_du_commentaire DATE NOT NULL,
                sites OTHER NOT NULL,
                id_Utilisateur INT NOT NULL,
                id_Sites INT NOT NULL,
                PRIMARY KEY (id_Commentaire)
);


ALTER TABLE Topo ADD CONSTRAINT new_tableutilisateur_cotation_fk
FOREIGN KEY (id_Utilisateur)
REFERENCES Utilisateur (id_Utilisateur)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Commentaire ADD CONSTRAINT new_tableutilisateur_commentaire_fk
FOREIGN KEY (id_Utilisateur)
REFERENCES Utilisateur (id_Utilisateur)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Commentaire ADD CONSTRAINT site_commentaire_fk
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
