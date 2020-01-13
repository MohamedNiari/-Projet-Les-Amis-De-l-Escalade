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
 * Bean Voie qui reprÂ©sente sous forme d'objet la table du mÂªme nom
 */
@Entity
public class Longueur {

	/*
	 * Colonne Id de la table voie avec auto-incrementation
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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
	 * Constructeur avec paramÃ¨tres
	 */
	public Longueur(Integer mesure, String cotation, Boolean equiperSpits, Integer numeroLongueur, Voie voie) {
		this.mesure = mesure;
		this.cotation = cotation;
		this.equiperSpits = equiperSpits;
		this.numeroLongueur = numeroLongueur;
		this.voie = voie;
	}

	/**************************************
	 * Generation des setters and getters *
	 **************************************/

	public Voie getVoie() {
		return voie;
	}

	public void setVoie(Voie voie) {
		this.voie = voie;
	}

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
		return "Longueur [longueurId=" + ", mesure=" + mesure + ", cotation=" + cotation
				+ ", equiperSpits=" + equiperSpits + ", numeroLongueur=" + numeroLongueur + ", voie=" + voie + "]";
	}

}
