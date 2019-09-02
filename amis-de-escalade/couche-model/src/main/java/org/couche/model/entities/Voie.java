package org.couche.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
 * Bean Voie qui représente sous forme d'objet la table du même nom
 */
@Entity
public class Voie {

	/*
	 * Colonne Id de la table voie avec auto-incrementation
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_Voie;
	private String nom;
	private Integer nombreLongueurs;
	private String cotation;
	private String description;
	private Boolean equiperSpits;
	private Integer numeroVoie;

	/*
	 * Relation "un à plusieurs" de voie à secteur sans supression en cascade
	 */
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "id_Secteur")
	private Secteur secteur;

	/*
	 * Constructeur
	 */
	public Voie() {

	}

	/*
	 * Constructeur avec Id
	 */
	public Voie(Long id_Voie, String nom, Integer nombreLongueurs, String cotation, String description,
			Boolean equiperSpits, Integer numeroVoie) {
		this.id_Voie = id_Voie;
		this.nom = nom;
		this.nombreLongueurs = nombreLongueurs;
		this.cotation = cotation;
		this.description = description;
		this.equiperSpits = equiperSpits;
		this.numeroVoie = numeroVoie;
	}

	/*
	 * Constructeur sans Id
	 */
	public Voie(String nom, Integer nombreLongueurs, String cotation, String description, Boolean equiperSpits,
			Integer numeroVoie) {
		this.nom = nom;
		this.nombreLongueurs = nombreLongueurs;
		this.cotation = cotation;
		this.description = description;
		this.equiperSpits = equiperSpits;
		this.numeroVoie = numeroVoie;
	}

	/**************************************
	 * Generation des setters and getters *
	 **************************************/

	public Long getId_Voie() {
		return id_Voie;
	}

	public void setId_Voie(Long id_Voie) {
		this.id_Voie = id_Voie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNombreLongueurs() {
		return nombreLongueurs;
	}

	public void setNombreLongueurs(int nombreLongueurs) {
		this.nombreLongueurs = nombreLongueurs;
	}

	public String getCotation() {
		return cotation;
	}

	public void setCotation(String cotation) {
		this.cotation = cotation;
	}

	public Boolean getEquiperSpits() {
		return equiperSpits;
	}

	public void setEquiperSpits(Boolean equiperSpits) {
		this.equiperSpits = equiperSpits;
	}

	public int getNumeroVoie() {
		return numeroVoie;
	}

	public void setNumeroVoie(int numeroVoie) {
		this.numeroVoie = numeroVoie;
	}

	public Secteur getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}

	public void setNombreLongueurs(Integer nombreLongueurs) {
		this.nombreLongueurs = nombreLongueurs;
	}

	public void setNumeroVoie(Integer numeroVoie) {
		this.numeroVoie = numeroVoie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
