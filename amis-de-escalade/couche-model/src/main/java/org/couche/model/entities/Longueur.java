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
<<<<<<< HEAD
 * Bean Voie qui repr©sente sous forme d'objet la table du mªme nom
=======
 * Bean Voie qui reprÂ©sente sous forme d'objet la table du mÂªme nom
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
 */
@Entity
public class Longueur {

	/*
	 * Colonne Id de la table voie avec auto-incrementation
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
	@Column(name = "voie_id")
	private Long longueurId;
	@Column(name = "longueur_metre")
	private Integer longueurMetre;

	/*
	 * Relation de voie   secteur sans supression en cascade
=======
	@Column(name = "longueur_id")
	private Long longueurId;
	@Column(name = "mesure")
	private Integer mesure;
	@Column(name = "cotation")
	private String cotation;
	@Column(name = "equiper_spits")
	private Boolean equiperSpits;
	@Column(name = "numero_longueur")
	private Integer numeroLongueur;

	/*
	 * Relation de voie Â  secteur sans supression en cascade
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
	 */
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "voie_id")
	private Voie voie;

	/*
	 * Constructeur
	 */
	public Longueur() {

	}

	/*
<<<<<<< HEAD
	 * Constructeur avec paramètres
	 */
	public Longueur(Integer longueurMetre, Voie voie) {
		this.longueurMetre = longueurMetre;
=======
	 * Constructeur avec paramÃ¨tres
	 */
	public Longueur(Integer mesure, String cotation, Boolean equiperSpits, Integer numeroLongueur, Voie voie) {
		this.mesure = mesure;
		this.cotation = cotation;
		this.equiperSpits = equiperSpits;
		this.numeroLongueur = numeroLongueur;
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
		this.voie = voie;
	}

	/**************************************
	 * Generation des setters and getters *
	 **************************************/

	public Long getLongueurId() {
		return longueurId;
	}

	public void setLongueurId(Long longueurId) {
		this.longueurId = longueurId;
	}

<<<<<<< HEAD
	public Integer getLongueurMetre() {
		return longueurMetre;
	}

	public void setLongueurMetre(Integer longueurMetre) {
		this.longueurMetre = longueurMetre;
	}

=======
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
	public Voie getVoie() {
		return voie;
	}

	public void setVoie(Voie voie) {
		this.voie = voie;
	}

<<<<<<< HEAD
	@Override
	public String toString() {
		return "Longueur [longueurId=" + longueurId + ", longueurMetre=" + longueurMetre + ", voie=" + voie + "]";
=======
	public Integer getMesure() {
		return mesure;
	}

	public void setMesure(Integer mesure) {
		this.mesure = mesure;
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

	public Integer getNumeroLongueur() {
		return numeroLongueur;
	}

	public void setNumeroLongueur(Integer numeroLongueur) {
		this.numeroLongueur = numeroLongueur;
	}

	@Override
	public String toString() {
		return "Longueur [longueurId=" + longueurId + ", mesure=" + mesure + ", cotation=" + cotation
				+ ", equiperSpits=" + equiperSpits + ", numeroLongueur=" + numeroLongueur + ", voie=" + voie + "]";
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
	}

}
