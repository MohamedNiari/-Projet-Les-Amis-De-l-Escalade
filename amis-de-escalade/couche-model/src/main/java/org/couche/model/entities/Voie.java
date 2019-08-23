package org.couche.model.entities;

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
	private String descriptions;
	private Boolean equiperSpits;
	private Integer numeroVoie;

	/*
	 * Relation "plusieurs à un" de voie à secteur
	 */
	@ManyToOne
	@JoinColumn(name = "id_Secteur")
	private Secteur secteur;
	
	
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

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
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

}
