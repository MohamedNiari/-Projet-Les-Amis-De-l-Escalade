package org.couche.model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/*
 * Bean Voie qui reprà©sente sous forme d'objet la table du màªme nom
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
	@Column(name = "nombre_longueur")
	private Integer nombreLongueurs;
	private String cotation;
	@Column(name = "equiper_spits")
	private Boolean equiperSpits;
	@Column(name = "numero_voie")
	private Integer numeroVoie;

	/*
	 * Relation de voie à  secteur sans supression en cascade
	 */
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "secteur_id")
	private Secteur secteur;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "voie", cascade = { CascadeType.ALL })
	private List<Longueur> longueurs;

	/*
	 * Constructeur
	 */
	public Voie() {

	}

	/*
	 * Constructeur avec paramètres
	 */
	public Voie(Integer nombreLongueurs, String cotation, Boolean equiperSpits, Integer numeroVoie, Secteur secteur) {
		this.nombreLongueurs = nombreLongueurs;
		this.cotation = cotation;
		this.equiperSpits = equiperSpits;
		this.numeroVoie = numeroVoie;
		this.secteur = secteur;
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

	public Long getVoieId() {
		return voieId;
	}

	public void setVoieId(Long voieId) {
		this.voieId = voieId;
	}

}
