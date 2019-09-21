package org.couche.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "voie_id")
	private Long voieId;
	private String nom;
	@Column(name = "nombre_longueur")
	private Integer nombreLongueurs;
	private String cotation;
	private String description;
	@Column(name = "equiper_spits")
	private Boolean equiperSpits;
	@Column(name = "numero_voie")
	private Integer numeroVoie;

	/*
	 * Relation de voie à secteur sans supression en cascade
	 */
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "secteur_id")
	private Secteur secteur;

	/*
	 * Constructeur
	 */
	public Voie() {

	}

	/*
	 * Constructeur avec Id
	 */
	public Voie(String nom, Integer nombreLongueurs, String cotation, String description,
			Boolean equiperSpits, Integer numeroVoie, Secteur secteur) {
		this.nom = nom;
		this.nombreLongueurs = nombreLongueurs;
		this.cotation = cotation;
		this.description = description;
		this.equiperSpits = equiperSpits;
		this.numeroVoie = numeroVoie;
		this.secteur = secteur;
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
		return voieId;
	}

	public void setId_Voie(Long id_Voie) {
		this.voieId = id_Voie;
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
	
	
	public Long getVoieId() {
		return voieId;
	}

	public void setVoieId(Long voieId) {
		this.voieId = voieId;
	}

	@Override
	public String toString() {
		return "Voie [voieId=" + voieId + ", nom=" + nom + ", nombreLongueurs=" + nombreLongueurs + ", cotation="
				+ cotation + ", description=" + description + ", equiperSpits=" + equiperSpits + ", numeroVoie="
				+ numeroVoie + ", secteur=" + secteur + "]";
	}

}
