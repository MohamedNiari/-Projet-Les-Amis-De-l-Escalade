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
<<<<<<< HEAD
 * Bean Voie qui reprà©sente sous forme d'objet la table du màªme nom
=======
 * Bean Voie qui reprÃ Â©sente sous forme d'objet la table du mÃ Âªme nom
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
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
<<<<<<< HEAD
	@Column(name = "nombre_longueur")
	private Integer nombreLongueurs;
	private String cotation;
	@Column(name = "equiper_spits")
	private Boolean equiperSpits;
	@Column(name = "numero_voie")
	private Integer numeroVoie;

	/*
	 * Relation de voie à  secteur sans supression en cascade
=======
	@Column(name = "numero_voie")
	private Integer numeroVoie;
	@Column(name = "nombre_longueur")
	private Integer nombreLongueurs;

	/*
	 * Relation de voie à secteur sans supression en cascade
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
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
<<<<<<< HEAD
	public Voie(Integer nombreLongueurs, String cotation, Boolean equiperSpits, Integer numeroVoie, Secteur secteur) {
		this.nombreLongueurs = nombreLongueurs;
		this.cotation = cotation;
		this.equiperSpits = equiperSpits;
=======
	public Voie(Integer nombreLongueurs, Integer numeroVoie, Secteur secteur) {
		this.nombreLongueurs = nombreLongueurs;
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
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

<<<<<<< HEAD
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

=======
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
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

<<<<<<< HEAD
=======
	public List<Longueur> getLongueurs() {
		return longueurs;
	}

	public void setLongueurs(List<Longueur> longueurs) {
		this.longueurs = longueurs;
	}

	@Override
	public String toString() {
		return "Voie [voieId=" + voieId + ", numeroVoie=" + numeroVoie + ", nombreLongueurs=" + nombreLongueurs
				+ ", secteur=" + secteur + ", longueurs=" + longueurs + "]";
	}

	
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
}
